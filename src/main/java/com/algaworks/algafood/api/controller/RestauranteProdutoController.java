package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.ProductInputDisassembler;
import com.algaworks.algafood.api.assembler.ProdutoModelAssembler;
import com.algaworks.algafood.api.model.ProdutoModel;
import com.algaworks.algafood.api.model.input.ProdutoInput;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.ProdutoRepository;
import com.algaworks.algafood.domain.service.CadastroProdutoService;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos")
public class RestauranteProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @Autowired
    private ProdutoModelAssembler produtoModelAssembler;

    @Autowired
    private ProductInputDisassembler productInputDisassembler;

    @GetMapping
    public List<ProdutoModel> listar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestauranteService.encontrar(restauranteId);

        List<Produto> todosProdutos = produtoRepository.findByRestaurante(restaurante);

        return produtoModelAssembler.toCollectionModel(todosProdutos);
    }

    @GetMapping("/{produtoId}")
    public ProdutoModel buscar(@PathVariable Long restauranteId, @PathVariable Long produtoId) {
        Produto produto = cadastroProdutoService.encontrar(restauranteId, produtoId);

        return produtoModelAssembler.toModel(produto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel adicionar(@PathVariable Long restauranteId,
                                  @RequestBody @Valid ProdutoInput produtoInput) {
        Restaurante restaurante = cadastroRestauranteService.encontrar(restauranteId);

        Produto produto = productInputDisassembler.toDomainObject(produtoInput);

        produto.setRestaurante(restaurante);

        produto = cadastroProdutoService.salvar(produto);

        return produtoModelAssembler.toModel(produto);
    }

    @PutMapping("/{produtoId}")
    public ProdutoModel atualizar(@PathVariable Long restauranteId,
                                  @PathVariable Long produtoId,
                                  @RequestBody @Valid ProdutoInput produtoInput) {
        Produto produtoAtual = cadastroProdutoService.encontrar(restauranteId, produtoId);

        productInputDisassembler.copyToDomainObject(produtoInput, produtoAtual);

        produtoAtual = cadastroProdutoService.salvar(produtoAtual);

        return produtoModelAssembler.toModel(produtoAtual);
    }

}
