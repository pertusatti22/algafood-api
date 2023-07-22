package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

//@ApiModel(value = "Cidade", description = "Representa uma cidade")
@Getter
@Setter
public class CidadeModel {

    @ApiModelProperty(value = "ID daCidade", example = "1")
    private Long id;

    @ApiModelProperty(value = "cidade", example = "São Paulo")
    private String nome;

    private EstadoModel estado;
}
