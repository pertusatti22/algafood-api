package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();

    Permissao buscar(long id);

    Permissao salvar(Permissao permissao);

    void remover(Permissao permissao);
}
