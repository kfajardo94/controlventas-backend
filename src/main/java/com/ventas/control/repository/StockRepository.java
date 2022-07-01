package com.ventas.control.repository;

import com.ventas.control.bo.Producto;
import com.ventas.control.bo.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock getById(Long id);

    @Query("SELECT new com.ventas.control.bo.Stock(s.id, s.producto, s.cantidad, s.precioCompra, s.fecha) " +
            "FROM Stock s " +
            "WHERE s.producto LIKE ?1 " +
            "and s.fecha between ?2 and ?3")
    Page<Stock> getByPage(Producto producto, Date fechaInicio, Date fechaFin, Pageable pageable);

}
