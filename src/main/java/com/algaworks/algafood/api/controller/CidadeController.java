package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.CidadeInputDisassembler;
import com.algaworks.algafood.api.assembler.CidadeModelAssembler;
import com.algaworks.algafood.api.model.CidadeModel;
import com.algaworks.algafood.api.model.input.CidadeInput;
import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Cidades")
@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private CadastroCidadeService cadastroCidadeService;
    @Autowired
    private CidadeModelAssembler cidadeModelAssembler;
    @Autowired
    private CidadeInputDisassembler cidadeInputDisassembler;


    @ApiOperation("Lista as cidades")
    @GetMapping
    public List<CidadeModel> listar() {
        return cidadeModelAssembler.toCollectionModel(cidadeRepository.findAll());
    }

    @ApiOperation("Busca uma cidade por ID")
    @GetMapping("/{cidadeId}")
    public CidadeModel buscar(@ApiParam(value = "ID de uma cidade", example = "1") @PathVariable Long cidadeId) {
        return cidadeModelAssembler.toModel(cadastroCidadeService.encontrar(cidadeId));
    }

    @ApiOperation("Cadastra uma cidade")
    @PostMapping
    public CidadeModel adicionar(@RequestBody @Valid CidadeInput cidadeInput) {
        try {
            Cidade cidade = cidadeInputDisassembler.toDomainObject(cidadeInput);

            return cidadeModelAssembler.toModel(cadastroCidadeService.salvar(cidade));
        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @ApiOperation("Atualiza uma cidade")
    @PutMapping("/{cidadeId}")
    public CidadeModel atualizar(@PathVariable Long cidadeId, @RequestBody @Valid CidadeInput cidadeInput) {
        try {
            Cidade cidadeAtual = cadastroCidadeService.encontrar(cidadeId);

            cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeAtual);

            return cidadeModelAssembler.toModel(cadastroCidadeService.salvar(cidadeAtual));

        } catch (EstadoNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @ApiOperation("Remove uma cidade")
    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cidadeId) {
        cadastroCidadeService.remover(cidadeId);

    }
}
