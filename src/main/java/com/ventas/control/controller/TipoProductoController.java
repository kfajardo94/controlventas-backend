package com.ventas.control.controller;

import com.ventas.control.bo.Stock;
import com.ventas.control.bo.TipoProducto;
import com.ventas.control.dto.TipoProductoRequestDTO;
import com.ventas.control.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/tipoProducto", produces = { "application/json" })
public class TipoProductoController {

    @Autowired
    private final TipoProductoService service;

    public TipoProductoController(TipoProductoService service) {
        this.service = service;
    }

    public TipoProductoService getService() {return service;}


    @GetMapping(path = "/getById")
    @ResponseBody
    public TipoProducto getById(@RequestParam Long id){
        TipoProducto obj = service.getById(id);
        return obj;
    }

    @GetMapping(path = "/getAll")
    @ResponseBody
    public List<TipoProducto> getAll(){
        return service.getAll();
    }

    @PostMapping(path = "/getByPage")
    @ResponseBody
    public Page<TipoProducto> getByPage(@RequestBody TipoProductoRequestDTO request) {
        return service.getByPage(request);
    }

    @PostMapping
    @ResponseBody
    public TipoProducto save(@RequestBody TipoProducto obj){
        return service.save(obj);
    }

    @PutMapping
    @ResponseBody
    public TipoProducto update(@RequestBody TipoProducto obj){
        return service.save(obj);
    }

    @DeleteMapping
    @ResponseBody
    public void delete(@RequestParam Long id){
        service.delete(id);
    }

    @PostMapping(path = "/getValidadorUniques")
    @ResponseBody
    public String getValidadorUniques(@RequestBody TipoProductoRequestDTO requestDTO){
        String response = service.getUniqueValidator(requestDTO);
        return response;
    }
}
