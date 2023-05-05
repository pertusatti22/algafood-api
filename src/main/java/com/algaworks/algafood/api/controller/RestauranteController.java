package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }

    @GetMapping("/{restauranteId}")
    public Restaurante buscar(@PathVariable Long restauranteId) {
        return cadastroRestauranteService.encontrar(restauranteId);
    }

    @PostMapping
    public Restaurante adicionar(@RequestBody Restaurante restaurante) {
        return cadastroRestauranteService.salvar(restaurante);
    }

    @PutMapping("/{restauranteId}")
    public Restaurante atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
        Restaurante restauranteAtual = cadastroRestauranteService.encontrar(restauranteId);

        BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro", "produtos");

        return cadastroRestauranteService.salvar(restauranteAtual);
    }

    @DeleteMapping("/{restauranteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long restauranteId) {
        cadastroRestauranteService.remover(restauranteId);
    }

    @PatchMapping("/{restauranteId}")
    public Restaurante atualizarParcial(@PathVariable Long restauranteId,
                                        @RequestBody Map<String, Object> campos) {

        Restaurante restauranteAtual = cadastroRestauranteService.encontrar(restauranteId);
        
        merge(campos, restauranteAtual);

        return atualizar(restauranteId, restauranteAtual);
    }

    private static void merge(Map<String, Object> camposOrigem, Restaurante restauranteDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Restaurante restauranteOrigem = objectMapper.convertValue(camposOrigem, Restaurante.class);

        camposOrigem.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
            assert field != null;
            field.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

            ReflectionUtils.setField(field, restauranteDestino, novoValor);


        });
    }
}
