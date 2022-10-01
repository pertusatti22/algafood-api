package com.algaworks.algafood.di.service;


import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private Notificador notificador;

    // onde estamos injetando o notificador? no construtor, então ele é um ponto de injeção.
    @Autowired
    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;
    }

    // Quando temos dois construtores, o Autowired indica para o spring qual deve ser usado
    // no momento que a aplicação está sendo iniciada
    public AtivacaoClienteService(String qualquer) {

    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
