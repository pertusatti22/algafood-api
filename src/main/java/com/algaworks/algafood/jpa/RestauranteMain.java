package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class RestauranteMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Cheng Chui");
        restaurante1.setTaxaFrete(BigDecimal.valueOf(7.5));

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Mil e uma Esfirras");
        restaurante2.setTaxaFrete(BigDecimal.valueOf(17.5));

        // atribuindo na variável estamos retornando a instância ja persistida
        restaurante1 = restauranteRepository.salvar(restaurante1);
        restauranteRepository.salvar(restaurante2);

        System.out.println(restauranteRepository.buscar(restaurante1.getId()));

        Restaurante testeRestaurante = restauranteRepository.buscar(1L);
        System.out.println("Teste Restaurante: " + testeRestaurante.getNome());

        // Usando salvar para update
        restaurante2.setId(6L);
        restaurante2.setNome("Tapete de Carnes");
        restaurante2.setTaxaFrete(BigDecimal.valueOf(5.5));

        restauranteRepository.salvar(restaurante2);

        // teste de exclusão
//        Restaurante restaurante = new Restaurante();
//        restaurante.setId(1L);
//        restauranteRepository.remover(restaurante);

        List<Restaurante> restaurantes = restauranteRepository.listar();

        for (Restaurante r:restaurantes) {
            System.out.println(r.getNome());
        }
    }
}
