package com.algaworks.algafood.api.openapi.model;

import com.algaworks.algafood.api.model.CozinhaModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Links;

import java.util.List;

@ApiModel("CozinhasModel")
@Setter
@Getter
public class CozinhasModelOpenApi {

    private CozinhasEmbeddedModelOpenApi _embedded;
    private Links links;

    @ApiModel("CidadesEmbeddedModel")
    @Data
    public class CozinhasEmbeddedModelOpenApi {
        private List<CozinhaModel> cidades;
    }
}
