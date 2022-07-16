package com.ventas.control.impl;

import com.ventas.control.bo.CierreCaja;
import com.ventas.control.repository.CierreCajaRepository;
import com.ventas.control.service.CierreCajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CierreCajaServiceImpl implements CierreCajaService {

    @Autowired
    private CierreCajaRepository repository;

    @Override
    public CierreCaja getByFecha(Date fecha) {
        CierreCaja cierreCaja = repository.getByFecha(fecha);
        return cierreCaja;
    }

    @Override
    public CierreCaja save(CierreCaja obj) {
        return repository.save(obj);
    }

    @Override
    public CierreCaja getByFechaInmediata(Date fecha) {
        Page<CierreCaja> page = repository.getByFechaInmediata(fecha, PageRequest.of(0, 1));
        if (null != page && null != page.getContent() && page.getContent().size() > 0) {
            return page.getContent().get(0);
        }
        return null;
    }
}
