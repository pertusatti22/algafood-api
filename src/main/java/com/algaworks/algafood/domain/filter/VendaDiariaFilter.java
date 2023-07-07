package com.algaworks.algafood.domain.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaDiariaFilter {

    private Long totalVendas;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataCriacaoInicio;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataCriacaoFim;
}
