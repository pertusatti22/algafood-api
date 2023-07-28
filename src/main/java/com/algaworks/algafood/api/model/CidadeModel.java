package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class CidadeModel extends RepresentationModel<CidadeModel> {

    @ApiModelProperty(value = "ID daCidade", example = "1")
    private Long id;

    @ApiModelProperty(value = "cidade", example = "São Paulo")
    private String nome;

    private EstadoModel estado;
}
