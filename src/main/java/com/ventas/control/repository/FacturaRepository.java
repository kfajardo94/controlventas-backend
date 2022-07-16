package com.ventas.control.repository;

import com.ventas.control.bo.Factura;
import com.ventas.control.dto.FacturaResponseDTO;
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
            "and (?5 is null or f.tipo like %?6%) "+
            "and f.fecha between ?7 and ?8")
    Page<Factura> getByPage(Long idSource, Long id, String codigoSource, String codigo,
                            String tipoSource, String tipo, Date fechaInicio, Date fechaFin, Pageable pageable);

    Factura getByCodigoAndTipo(String codigo, String tipo);

    @Query("SELECT new com.ventas.control.dto.FacturaResponseDTO(sum(f.total), f.tipo) " +
            "FROM Factura f " +
            "WHERE f.tipo = 'C' AND (f.fecha between IFNULL(?1, '1900-01-01') and ?2)")
    FacturaResponseDTO getTotalCompras(Date fechaInicio, Date fechaFin);

    @Query("SELECT new com.ventas.control.dto.FacturaResponseDTO(sum(f.total), f.tipo) " +
            "FROM Factura f " +
            "WHERE f.tipo = 'V' AND (f.fecha between IFNULL(?1, '1900-01-01') and ?2)")
    FacturaResponseDTO getTotalVentas(Date fechaInicio, Date fechaFin);

}
