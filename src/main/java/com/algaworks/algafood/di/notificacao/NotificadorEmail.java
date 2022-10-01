package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;


@Component
public class NotificadorEmail implements Notificador {

    public NotificadorEmail() {
        System.out.println("NotificadorEmail");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
