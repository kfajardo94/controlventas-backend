package com.ventas.control.controller;

import com.ventas.control.bo.Producto;
import com.ventas.control.bo.TipoProducto;
import com.ventas.control.dto.ProductoRequestDTO;
import com.ventas.control.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/producto", produces = { "application/json" })
public class ProductoController {

    @Autowired
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    public ProductoService getService() {return service;}


    @GetMapping(path = "/getById")
    @ResponseBody
    public Producto getById(@RequestParam Long id){
        Producto obj = service.getById(id);
        return obj;
    }

    @GetMapping(path = "/getByCodigo")
    @ResponseBody
    public Producto getById(@RequestParam String codigo){
        Producto obj = service.getByCodigo(codigo);
        return obj;
    }

    @GetMapping(path = "/getAll")
    @ResponseBody
    public List<Producto> getAll(){
        return service.getAll();
    }

    @PostMapping(path = "/getByPage")
    @ResponseBody
    public Page<Producto> getByPage(@RequestBody ProductoRequestDTO request) {
        return service.getByPage(request);
    }

    @PostMapping
    @ResponseBody
    public Producto save(@RequestBody Producto obj){
        return service.save(obj);
    }

    @PutMapping
    @ResponseBody
    public Producto update(@RequestBody Producto obj){
        return service.save(obj);
    }

    @DeleteMapping
    @ResponseBody
    public void delete(@RequestParam Long id){
        service.delete(id);
    }

    @GetMapping(path = "/getByTipoProducto")
    @ResponseBody
    public Producto getByTipoProducto(@RequestParam Long idTipoProducto){
        Producto obj = service.getByIdTipoProducto(idTipoProducto);
        return obj;
    }

    @PostMapping(path = "/getValidadorUniques")
    @ResponseBody
    public String getValidadorUniques(@RequestBody ProductoRequestDTO requestDTO){
        String response = service.getUniqueValidator(requestDTO);
        return response;
    }
}
