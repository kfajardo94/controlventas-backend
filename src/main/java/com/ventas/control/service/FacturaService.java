package com.ventas.control.service;

import com.ventas.control.bo.Factura;
import com.ventas.control.dto.FacturaRequestDTO;
import com.ventas.control.dto.FacturaResponseDTO;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface FacturaService {

    Factura getById(Long id);

    Page<Factura> getByPage(FacturaRequestDTO request);

    Factura save(Factura obj);

    void delete(Long id);

    List<Factura> getAll();

    String getUniqueValidator(Factura requestDTO);

    List<FacturaResponseDTO> getTotales(Date fechaInicio, Date fechaFin);

}
