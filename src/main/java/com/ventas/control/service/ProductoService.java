package com.ventas.control.service;

import com.ventas.control.bo.Producto;
import com.ventas.control.dto.ProductoRequestDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductoService {

    Producto getById(Long id);

    Page<Producto> getByPage(ProductoRequestDTO request);

    Producto save(Producto obj);

    void delete(Long id);

    String getUniqueValidator(ProductoRequestDTO requestDTO);

    List<Producto> getAll();

    Producto getByIdTipoProducto(Long idTipoProducto);
}
