package com.ventas.control.controller;

import com.ventas.control.bo.DetalleFactura;
import com.ventas.control.dto.DetalleFacturaRequestDTO;
import com.ventas.control.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/detalleFactura", produces = { "application/json" })
public class DetalleFacturaController {

    @Autowired
    private final DetalleFacturaService service;

    public DetalleFacturaController(DetalleFacturaService service) {
        this.service = service;
    }

    public DetalleFacturaService getService() {return service;}


    @GetMapping(path = "/getById")
    @ResponseBody
    public DetalleFactura getById(@RequestParam Long id){
        DetalleFactura obj = service.getById(id);
        return obj;
    }

    @PostMapping(path = "/getByPage")
    @ResponseBody
    public Page<DetalleFactura> getByPage(@RequestBody DetalleFacturaRequestDTO request) {
        return service.getPageByFactura(request);
    }

    @PostMapping
    @ResponseBody
    public void save(@RequestBody DetalleFacturaRequestDTO requestDTO){
        service.save(requestDTO);
    }

    @DeleteMapping
    @ResponseBody
    public void delete(@RequestParam Long id){
        service.delete(id);
    }

}
