package com.algaworks.algafood.core.modelmapper;

import com.algaworks.algafood.api.model.EnderecoModel;
import com.algaworks.algafood.domain.model.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
                Endereco.class, EnderecoModel.class
        );

        enderecoToEnderecoModelTypeMap.<String>addMapping(
                estado -> estado.getCidade().getEstado().getNome(),
                (nome, value) -> nome.getCidade().setEstado(value));

        return modelMapper;
    }
}
