package com.ventas.control.repository;

import com.ventas.control.bo.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Factura getById(Long id);

    @Query("SELECT new com.ventas.control.bo.Factura(f.id, f.codigo, f.tipo, " +
            "f.descripcion, f.fecha, f.total) " +
            "FROM Factura f " +
            "WHERE (?1 is null or CAST(f.id as string) LIKE %?2%) " +
            "and (?3 is null or f.codigo like %?4%) " +
            "and f.fecha between ?5 and ?6")
    Page<Factura> getByPage(Long idSource, Long id, String codigoSource, String codigo, Date fechaInicio, Date fechaFin, Pageable pageable);

}
