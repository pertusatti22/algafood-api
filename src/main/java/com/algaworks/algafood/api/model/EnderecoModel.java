package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoModel {

    @ApiModelProperty(example = "38400-000")
    private String cep;
    @ApiModelProperty(example = "Avenida Brasil")
    private String logradouro;
    @ApiModelProperty(example = "\"1500\"")
    private String numero;
    @ApiModelProperty(example = "Apto 204")
    private String complemento;
    @ApiModelProperty(example = "Centro")
    private String bairro;
    private CidadeResumoModel cidade;


}
