package com.ventas.control.repository;

import com.ventas.control.bo.CierreCaja;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface CierreCajaRepository extends JpaRepository<CierreCaja, Long> {

    @Query("select new com.ventas.control.bo.CierreCaja(cc.id, cc.fecha, cc.saldoAnterior, cc.saldoCierre, cc.fechaHoraCierre) " +
            "from CierreCaja cc " +
            "where cc.fecha <= ?1 " +
            "order by cc.fecha desc")
    Page<CierreCaja> getByFechaInmediata(Date fecha, Pageable pageable);

    CierreCaja getByFecha(Date fecha);

}
