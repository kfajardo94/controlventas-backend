package com.ventas.control.service;

import com.ventas.control.bo.CierreCaja;

import java.util.Date;

public interface CierreCajaService {

    CierreCaja getByFecha(Date fecha);

    CierreCaja save(CierreCaja obj);

    CierreCaja getByFechaInmediata(Date fecha);

}
