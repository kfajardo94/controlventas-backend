package com.ventas.control.impl;

import com.ventas.control.bo.Factura;
import com.ventas.control.bo.Producto;
import com.ventas.control.dto.FacturaRequestDTO;
import com.ventas.control.dto.ProductoRequestDTO;
import com.ventas.control.repository.FacturaRepository;
import com.ventas.control.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository repository;

    @Override
    public Factura getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Page<Factura> getByPage(FacturaRequestDTO request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Page<Factura> response = repository.getByPage(request.getObj().getId(), request.getObj().getId() == null ? 0l : request.getObj().getId(),
                request.getObj().getCodigo(), request.getObj().getCodigo() == null ? "" : request.getObj().getCodigo(),
                request.getObj().getTipo(), request.getObj().getTipo() == null ? "" : request.getObj().getTipo(),
                request.getFechaInicio(), request.getFechaFin(),
                pageable);
        return response;
    }

    @Override
    public Factura save(Factura obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        Factura obj = getById(id);
        if (obj != null) {
            repository.delete(obj);
        }
    }

    @Override
    public List<Factura> getAll() {
        return repository.findAll(Sort.by("nombre").ascending());
    }

    @Override
    public String getUniqueValidator(Factura requestDTO) {

        if (null != requestDTO && null != requestDTO.getCodigo()) {
            Factura f = repository.getByCodigoAndTipo(requestDTO.getCodigo(), requestDTO.getTipo());
            if (null != f && (f.getId() != requestDTO.getId())){
                return "El código ingresado ya se encuentra registrado";
            }
        }
        return null;
    }
}
