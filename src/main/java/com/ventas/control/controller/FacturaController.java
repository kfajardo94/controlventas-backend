package com.ventas.control.controller;

import com.ventas.control.bo.Factura;
import com.ventas.control.dto.FacturaRequestDTO;
import com.ventas.control.dto.FacturaResponseDTO;
import com.ventas.control.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/factura", produces = { "application/json" })
public class FacturaController {

    @Autowired
    private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }

    public FacturaService getService() {return service;}


    @GetMapping(path = "/getById")
    @ResponseBody
    public Factura getById(@RequestParam Long id){
        Factura obj = service.getById(id);
        return obj;
    }

    @GetMapping(path = "/getAll")
    @ResponseBody
    public List<Factura> getAll(){
        return service.getAll();
    }

    @PostMapping(path = "/getByPage")
    @ResponseBody
    public Page<Factura> getByPage(@RequestBody FacturaRequestDTO request) {
        return service.getByPage(request);
    }

    @PostMapping
    @ResponseBody
    public Factura save(@RequestBody Factura obj){
        return service.save(obj);
    }

    @PutMapping
    @ResponseBody
    public Factura update(@RequestBody Factura obj){
        return service.save(obj);
    }

    @DeleteMapping
    @ResponseBody
    public void delete(@RequestParam Long id){
        service.delete(id);
    }

    @PostMapping(path = "/getValidadorUniques")
    @ResponseBody
    public String getValidadorUniques(@RequestBody Factura obj){
        String response = service.getUniqueValidator(obj);
        return response;
    }

    @PostMapping(path = "/getTotales")
    @ResponseBody
    public List<FacturaResponseDTO> getTotales(@RequestBody FacturaRequestDTO requestDTO){
        return service.getTotales(requestDTO);
    }

}
