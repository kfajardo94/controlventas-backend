package com.ventas.control.controller;

import com.ventas.control.bo.CierreCaja;
import com.ventas.control.dto.CierreCajaRequestDTO;
import com.ventas.control.service.CierreCajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/cierreCaja", produces = { "application/json" })
public class CierreCajaController {

    @Autowired
    private final CierreCajaService service;

    public CierreCajaController(CierreCajaService service) {
        this.service = service;
    }

    public CierreCajaService getService() {return service;}

    @GetMapping(path = "/getByFecha")
    @ResponseBody
    public CierreCaja getByProducto(@RequestParam Date fecha){
        CierreCaja obj = service.getByFecha(fecha);
        return obj;
    }

    @PostMapping(path = "/getFechaInmediataByFecha")
    @ResponseBody
    public CierreCaja getFechaInmediataByFecha(@RequestBody CierreCajaRequestDTO requestDTO){
        CierreCaja obj = service.getByFechaInmediata(requestDTO.getFechaInmediata());
        return obj;
    }

    @PostMapping
    @ResponseBody
    public CierreCaja save(@RequestBody CierreCaja obj){
        return service.save(obj);
    }


}
