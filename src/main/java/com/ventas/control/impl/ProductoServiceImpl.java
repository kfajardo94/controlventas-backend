package com.ventas.control.impl;

import com.ventas.control.bo.Producto;
import com.ventas.control.dto.ProductoRequestDTO;
import com.ventas.control.repository.ProductoRepository;
import com.ventas.control.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto getById(Long id) {
        Producto obj = repository.getById(id);
        obj.setImagenStr(new String(obj.getImagen()));
        return obj;
    }

    @Override
    public Page<Producto> getByPage(ProductoRequestDTO request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by("nombre").ascending());

        Page<Producto> response = repository.getByPage(request.getProducto().getId(), request.getProducto().getId() == null ? 0l : request.getProducto().getId(),
                request.getProducto().getCodigo(), request.getProducto().getCodigo() == null ? "" : request.getProducto().getCodigo(),
                request.getProducto().getNombre(), request.getProducto().getNombre() == null ? "" : request.getProducto().getNombre(),
                pageable);

        for (Producto prod : response.getContent()){
            prod.setImagenStr(new String(prod.getImagen()));
        }

        return response;
    }

    @Override
    public Producto save(Producto obj) {
        System.out.println("obj: "+obj.getFechaVencimiento());
        obj.setImagen(obj.getImagenStr().getBytes());
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        Producto obj = getById(id);
        if (obj != null) {
            repository.delete(obj);
        }
    }

    @Override
    public String getUniqueValidator(ProductoRequestDTO requestDTO) {

        if (null != requestDTO && null != requestDTO.getProducto()) {
            Producto tp = repository.getByCodigo(requestDTO.getProducto().getCodigo());
            if (null != tp && (tp.getId() != requestDTO.getProducto().getId())){
                return "El código ingresado ya se encuentra registrado";
            }

            Producto tp2 = repository.getByNombre(requestDTO.getProducto().getNombre());
            if (null != tp2 && (tp2.getId() != requestDTO.getProducto().getId())){
                return "El nombre ingresado ya se encuentra registrado";
            }
        }
        return null;
    }

    @Override
    public List<Producto> getAll() {
        List<Producto> lst = repository.findAll(Sort.by("nombre").ascending());
        for (Producto obj : lst){
            obj.setImagenStr(new String(obj.getImagen()));
        }
        return lst;
    }
}
