package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

//    @GetMapping("/cozinhas/por-nome")
//    public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) {
//        return cozinhaRepository.consultarPorNome(nome);
//    }
}
