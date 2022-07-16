package com.ventas.control.dto;

import com.ventas.control.bo.Factura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class FacturaResponseDTO {

    private Double totalFacturas;
    private String tipo;

    public FacturaResponseDTO(Double totalFacturas, String tipo) {
        this.totalFacturas = totalFacturas;
        this.tipo = tipo;
    }
}
