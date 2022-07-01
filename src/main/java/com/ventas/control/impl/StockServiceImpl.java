package com.ventas.control.impl;

import com.ventas.control.bo.Stock;
import com.ventas.control.dto.StockRequestDTO;
import com.ventas.control.repository.StockRepository;
import com.ventas.control.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository repository;

    @Override
    public Stock getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Page<Stock> getByPage(StockRequestDTO request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Page<Stock> response = repository.getByPage(request.getStock().getProducto(), request.getFechaInicio(),
                request.getFechaFin(), pageable);

        return response;
    }

    @Override
    public Stock save(Stock obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        Stock obj = getById(id);
        if (obj != null) {
            repository.delete(obj);
        }
    }

}
