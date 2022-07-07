package com.ventas.control.impl;

import com.ventas.control.bo.DetalleFactura;
import com.ventas.control.dto.DetalleFacturaRequestDTO;
import com.ventas.control.repository.DetalleFacturaRepository;
import com.ventas.control.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository repository;

    @Override
    public DetalleFactura getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Page<DetalleFactura> getPageByFactura(DetalleFacturaRequestDTO request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Page<DetalleFactura> response = repository.getPageByFactura(request.getFactura(),
                pageable);
        return response;
    }

    @Override
    public void save(DetalleFacturaRequestDTO requestDTO) {
        if (null != requestDTO && null != requestDTO.getLstDetalle() && requestDTO.getLstDetalle().size() > 0){
            for (DetalleFactura obj : requestDTO.getLstDetalle()) {
                repository.save(obj);
            }
        }
    }

    @Override
    public void delete(Long id) {
        DetalleFactura obj = getById(id);
        if (obj != null) {
            repository.delete(obj);
        }
    }

}
