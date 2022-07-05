package com.ventas.control.repository;

import com.ventas.control.bo.Producto;
import com.ventas.control.bo.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock getByProducto(Long id);

}
