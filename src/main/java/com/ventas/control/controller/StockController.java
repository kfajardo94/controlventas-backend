package com.ventas.control.controller;

import com.ventas.control.bo.Stock;
import com.ventas.control.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/stock", produces = { "application/json" })
public class StockController {

    @Autowired
    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    public StockService getService() {return service;}

    @GetMapping(path = "/getById")
    @ResponseBody
    public Stock getById(@RequestParam Long id){
        Stock obj = service.getById(id);
        return obj;
    }

    @PostMapping
    @ResponseBody
    public Stock save(@RequestBody Stock obj){
        return service.save(obj);
    }

    @PutMapping
    @ResponseBody
    public Stock update(@RequestBody Stock obj){
        return service.save(obj);
    }

    @DeleteMapping
    @ResponseBody
    public void delete(@RequestParam Long id){
        service.delete(id);
    }

}
