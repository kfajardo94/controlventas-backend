package com.ventas.control.dto;

import com.ventas.control.bo.Factura;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FacturaRequestDTO {
    private Factura obj;
    private Date fechaInicio;
    private Date fechaFin;
    private int page;
    private int size;

    @Override
    public String toString() {
        return "FacturaRequestDTO{" +
                "obj=" + obj +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}
