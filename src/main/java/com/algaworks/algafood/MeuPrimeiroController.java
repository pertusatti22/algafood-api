package com.algaworks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Transforma a classe em uma controller para o Spring
public class MeuPrimeiroController {

    @GetMapping("/hello") //Indica o endpoint para acessar a controller no navegador
    @ResponseBody //Indica que o body seja devolvido pro navegador no retorno
    public String hello(){
        return "Hello!";
    }

}
