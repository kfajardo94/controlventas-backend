package com.ventas.control.service;

import com.ventas.control.bo.DetalleFactura;
import com.ventas.control.dto.DetalleFacturaRequestDTO;
import org.springframework.data.domain.Page;

public interface DetalleFacturaService {

    DetalleFactura getById(Long id);

    Page<DetalleFactura> getPageByFactura(DetalleFacturaRequestDTO request);

    void save(DetalleFacturaRequestDTO requestDTO);

    void delete(Long id);

}
