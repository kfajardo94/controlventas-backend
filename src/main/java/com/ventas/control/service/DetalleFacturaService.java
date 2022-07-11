package com.ventas.control.service;

import com.ventas.control.bo.DetalleFactura;
import com.ventas.control.dto.DetalleFacturaRequestDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DetalleFacturaService {

    DetalleFactura getById(Long id);

    Page<DetalleFactura> getPageByFactura(DetalleFacturaRequestDTO request);

    List<DetalleFactura> getByFactura(DetalleFacturaRequestDTO request);

    void save(DetalleFacturaRequestDTO requestDTO);

    void delete(Long id);

}
