package com.ventas.control.dto;

import com.ventas.control.bo.Stock;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StockRequestDTO {
    private Stock stock;
    private Date fechaInicio;
    private Date fechaFin;
    private int page;
    private int size;


}
