package com.ventas.control.repository;

import com.ventas.control.bo.DetalleFactura;
import com.ventas.control.bo.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {

    DetalleFactura getById(Long id);

    @Query("SELECT new com.ventas.control.bo.DetalleFactura(df.id, df.factura, df.producto, " +
            "df.cantidad, df.total) " +
            "FROM DetalleFactura df " +
            "WHERE df.factura = ?1 ")
    Page<DetalleFactura> getPageByFactura(Factura factura, Pageable pageable);

}
