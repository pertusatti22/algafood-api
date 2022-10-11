package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();
    Estado buscar(long id);
    Estado salvar(Estado estado);
    void remover(Estado estado);
}
