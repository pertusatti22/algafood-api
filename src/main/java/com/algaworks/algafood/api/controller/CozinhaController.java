package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.CozinhaInputDisassembler;
import com.algaworks.algafood.api.assembler.CozinhaModelAssembler;
import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.api.model.input.CozinhaInput;
import com.algaworks.algafood.api.openapi.controller.CozinhasControllerOpenApi;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController implements CozinhasControllerOpenApi {

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;
    @Autowired
    private CozinhaRepository cozinhaRepository;
    @Autowired
    private CozinhaModelAssembler cozinhaModelAssembler;
    @Autowired
    private CozinhaInputDisassembler cozinhaInputDisassembler;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<CozinhaModel> listar(@PageableDefault(size = 10) Pageable pageable) {
        Page<Cozinha> cozinhasPage = cozinhaRepository.findAll(pageable);

        List<CozinhaModel> cozinhasModel = cozinhaModelAssembler.toCollectionModel(cozinhasPage.getContent());

        Page<CozinhaModel> cozinhasModelPage = new PageImpl<>(cozinhasModel, pageable, cozinhasPage.getTotalElements());

        return cozinhasModelPage;
    }

    @GetMapping(value = "/{cozinhaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CozinhaModel buscar(@PathVariable Long cozinhaId) {
        Cozinha cozinha = cadastroCozinhaService.encontrar(cozinhaId);

        return cozinhaModelAssembler.toModel(cozinha);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CozinhaModel adicionar(@RequestBody @Valid CozinhaInput cozinhaInput) {
        try {
            Cozinha cozinha = cozinhaInputDisassembler.toDomainObject(cozinhaInput);

            return cozinhaModelAssembler.toModel(cadastroCozinhaService.salvar(cozinha));
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping(value = "/{cozinhaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CozinhaModel atualizar(@PathVariable Long cozinhaId, @RequestBody @Valid CozinhaInput cozinhaInput) {
        try {
            Cozinha cozinhaAtual = cadastroCozinhaService.encontrar(cozinhaId);

            cozinhaInputDisassembler.copyToDomainObject(cozinhaInput, cozinhaAtual);

            return cozinhaModelAssembler.toModel(cadastroCozinhaService.salvar(cozinhaAtual));


        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{cozinhaId}", produces = {})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cozinhaId) {
        cadastroCozinhaService.remover(cozinhaId);
    }
}
