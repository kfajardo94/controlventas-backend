package com.ventas.control.service;

import com.ventas.control.bo.TipoProducto;
import com.ventas.control.dto.TipoProductoRequestDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TipoProductoService {

    TipoProducto getById(Long id);

    Page<TipoProducto> getByPage(TipoProductoRequestDTO request);

    TipoProducto save(TipoProducto obj);

    void delete(Long id);

    String getUniqueValidator(TipoProductoRequestDTO requestDTO);

    List<TipoProducto> getAll();

}
