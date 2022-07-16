package com.ventas.control.service;

import com.ventas.control.bo.Stock;

public interface StockService {

    Stock getById(Long id);

    Stock getByIdProducto(Long idProducto);

    Stock save(Stock obj);

    void delete(Long id);

}
