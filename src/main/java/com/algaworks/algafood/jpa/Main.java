package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.*;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setNome("Japonesa");
        cozinha = cozinhaRepository.salvar(cozinha);

        cozinha.setNome("Árabe");
        cozinha = cozinhaRepository.salvar(cozinha);
        System.out.println(cozinhaRepository.buscar(cozinha.getId()));

        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Cheng Chui");
        restaurante.setTaxaFrete(BigDecimal.valueOf(6.5));
        restaurante.setCozinha(cozinhaRepository.buscar(4L));
        restaurante = restauranteRepository.salvar(restaurante);

        restaurante.setNome("Mil e uma Esfirras");
        restaurante.setTaxaFrete(BigDecimal.valueOf(6.5));
        restaurante.setCozinha(cozinhaRepository.buscar(3L));
        restaurante = restauranteRepository.salvar(restaurante);

        System.out.println(restauranteRepository.buscar(restaurante.getId()));

        Cozinha testeCozinha = cozinhaRepository.buscar(1L);
        System.out.println("Teste Cozinha: " + testeCozinha.getNome());

        Restaurante testeRestaurante = restauranteRepository.buscar(1L);
        System.out.println("Teste Restaurante: " + testeRestaurante.getNome());


        // Usando salvar para update
        cozinha.setId(2L);
        cozinha.setNome("Persa");
        cozinhaRepository.salvar(cozinha);

        restaurante.setId(2L);
        restaurante.setNome("Tapete de Carnes");
        restaurante.setTaxaFrete(BigDecimal.valueOf(5.5));
        restaurante.setCozinha(cozinhaRepository.buscar(2L));
        restauranteRepository.salvar(restaurante);


        List<Cozinha> cozinhas = cozinhaRepository.listar();

        for (Cozinha c:cozinhas) {
            System.out.println(c.getNome());
        }

        List<Restaurante> restaurantes = restauranteRepository.listar();

        for (Restaurante r:restaurantes) {
            System.out.println(r.getNome());
        }

        List<FormaPagamento> formaPagamentos = formaPagamentoRepository.listar();

        for (FormaPagamento f:formaPagamentos) {
            System.out.println(f.getDescricao());
        }


        Cidade cidade = cidadeRepository.buscar(1L);
        System.out.println("A Cidade de " + cidade.getNome() + " está no Estado de " + cidade.getEstado().getNome());
    }
}
