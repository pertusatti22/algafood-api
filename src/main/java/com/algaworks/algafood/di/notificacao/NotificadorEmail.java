package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;


@Component // uma das formas de transformar a classe em um bean para ser gerenciado pelo spring "bean spring"
public class NotificadorEmail{

    public NotificadorEmail(){
        System.out.println("Construtor chamado");// Por ser um componente, ele já é instanciado no play da app
    }

    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
