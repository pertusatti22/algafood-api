package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> listar();
    Cidade buscar(long id);
    Cidade salvar(Cidade cidade);
    void remover(Cidade cidade);
}
