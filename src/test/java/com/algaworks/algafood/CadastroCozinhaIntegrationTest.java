package com.algaworks.algafood;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class CadastroCozinhaIntegrationTest {

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @Test
    public void testarCadastroCozinhaComSucesso() { // HappyPath
        // Cenário
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome("Chinesa");

        // Ação
        novaCozinha = cadastroCozinha.salvar(novaCozinha);

        // Validação
        assertThat(novaCozinha).isNotNull();
        assertThat(novaCozinha.getId()).isNotNull();
    }

    @Test
    public void testarCadastroCozinhaSemNome() { //UnhappyPath
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome(null);

        ConstraintViolationException erroEsperado =
                Assertions.assertThrows(ConstraintViolationException.class, () -> {
                    cadastroCozinha.salvar(novaCozinha);
                });

        assertThat(erroEsperado).isNotNull();
    }
}
