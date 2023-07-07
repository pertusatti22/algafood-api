package com.algaworks.algafood.infrastructure.service;

import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.domain.service.VendaReportService;
import org.springframework.stereotype.Service;

@Service
public class VendaPdfReportServiceImpl implements VendaReportService {


    @Override
    public byte[] emitirVendasDiarias(VendaDiariaFilter filter, String timeOffset) {
        return new byte[0];
    }
}
