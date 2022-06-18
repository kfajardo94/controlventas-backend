package com.ventas.control.dto;

import com.ventas.control.bo.Producto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequestDTO {
    private Producto producto;
    private int page;
    private int size;


}
