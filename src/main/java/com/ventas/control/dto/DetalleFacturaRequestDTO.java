package com.ventas.control.dto;

import com.ventas.control.bo.DetalleFactura;
import com.ventas.control.bo.Factura;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetalleFacturaRequestDTO {
    private List<DetalleFactura> lstDetalle;
    private DetalleFactura detalleFactura;
    private Factura factura;
    private int page;
    private int size;


}
