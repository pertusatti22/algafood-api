package com.algaworks.algafood.api.openapi.model;

import com.algaworks.algafood.api.model.RestauranteResumoModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.hateoas.Links;

import java.util.List;

@ApiModel("RestaurantesResumoModel")
@Data
public class RestaurantesResumoModelOpenApi {

    private RestaurantesEmbeddedModelOpenApi _embedded;
    private Links _links;

    @ApiModel("RestaurantesEmbeddedModel")
    @Data
    public class RestaurantesEmbeddedModelOpenApi {

        private List<RestauranteResumoModel> restaurantes;

    }

}