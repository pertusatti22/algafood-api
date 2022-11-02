package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CozinhaRepository {

    List<Cozinha> listar();

    List<Cozinha> consultarPorNome(String nome);

    Cozinha buscar(long id);

    Cozinha salvar(Cozinha cozinha);

    void remover(Long id);
}
