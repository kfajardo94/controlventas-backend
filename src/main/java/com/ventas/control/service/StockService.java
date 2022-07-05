package com.ventas.control.service;

import com.ventas.control.bo.Stock;
import com.ventas.control.dto.StockRequestDTO;
import org.springframework.data.domain.Page;

public interface StockService {

    Stock getById(Long id);

    Stock save(Stock obj);

    void delete(Long id);

}
