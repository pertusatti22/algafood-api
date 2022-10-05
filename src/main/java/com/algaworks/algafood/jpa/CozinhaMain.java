package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class CozinhaMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Japonesa");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Árabe");

        cadastroCozinha.adicionar(cozinha1);
        cadastroCozinha.adicionar(cozinha2);

        List<Cozinha> cozinhas = cadastroCozinha.listar();

        for (Cozinha cozinha:cozinhas) {
            System.out.println(cozinha.getNome());
        }
    }
}
