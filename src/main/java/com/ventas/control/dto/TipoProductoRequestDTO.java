package com.ventas.control.dto;

import com.ventas.control.bo.TipoProducto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoProductoRequestDTO {
    private TipoProducto tipoProducto;
    private int page;
    private int size;


}
