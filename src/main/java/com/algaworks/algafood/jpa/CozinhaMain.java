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

        // atribuindo na variável estamos retornando a instância ja persistida
        cozinha1 = cadastroCozinha.salvar(cozinha1);
        cadastroCozinha.salvar(cozinha2);

        System.out.println(cadastroCozinha.buscar(cozinha1.getId()));

        Cozinha testeCozinha = cadastroCozinha.buscar(1L);
        System.out.println("Teste Cozinha: " + testeCozinha.getNome());

        // Usando salvar para update
        cozinha2.setId(6L);
        cozinha2.setNome("Persa");

        cadastroCozinha.salvar(cozinha2);

        //teste de exclusão
//        Cozinha cozinha = new Cozinha();
//        cozinha.setId(1L);
//        cadastroCozinha.remover(cozinha);

        List<Cozinha> cozinhas = cadastroCozinha.listar();

        for (Cozinha c:cozinhas) {
            System.out.println(c.getNome());
        }
    }
}
