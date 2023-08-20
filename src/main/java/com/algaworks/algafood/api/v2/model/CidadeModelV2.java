package com.algaworks.algafood.api.v2.model;

import com.algaworks.algafood.api.v1.model.EstadoModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "cidades")
@Getter
@Setter
public class CidadeModelV2 extends RepresentationModel<CidadeModelV2> {

    @ApiModelProperty(value = "ID daCidade", example = "1")
    private Long id;

    @ApiModelProperty(value = "cidade", example = "São Paulo")
    private String nome;

    private EstadoModel estado;
}
