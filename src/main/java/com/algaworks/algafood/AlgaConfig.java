package com.algaworks.algafood;

import com.algaworks.algafood.di.notificacao.NotificadorEmail;
import com.algaworks.algafood.di.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //utilizado para definir configurações de beans
public class AlgaConfig {

    @Bean //indica que ele é um objeto que deve ser gerenciado pelo container spring
    public NotificadorEmail notificadorEmail() {
        NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
        notificador.setCaixaAlta(true);

        return notificador;
    }

    @Bean //para funcionar é necessário passar o notificarEmail no construtor e funciona pq ele é um bean spring também
    public AtivacaoClienteService ativacaoClienteService() {
        return new AtivacaoClienteService(notificadorEmail());
    }
}

