package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class CozinhaMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Japonesa");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Árabe");

        // atribuindo na variável estamos retornando a instância ja persistida
        cozinha1 = cozinhaRepository.salvar(cozinha1);
        cozinhaRepository.salvar(cozinha2);

        System.out.println(cozinhaRepository.buscar(cozinha1.getId()));

        Cozinha testeCozinha = cozinhaRepository.buscar(1L);
        System.out.println("Teste Cozinha: " + testeCozinha.getNome());

        // Usando salvar para update
        cozinha2.setId(6L);
        cozinha2.setNome("Persa");

        cozinhaRepository.salvar(cozinha2);

        //teste de exclusão
//        Cozinha cozinha = new Cozinha();
//        cozinha.setId(1L);
//        cozinhaRepository.remover(cozinha);

        List<Cozinha> cozinhas = cozinhaRepository.listar();

        for (Cozinha c:cozinhas) {
            System.out.println(c.getNome());
        }
    }
}
