package com.ventas.control.impl;

import com.ventas.control.bo.Producto;
import com.ventas.control.bo.TipoProducto;
import com.ventas.control.dto.TipoProductoRequestDTO;
import com.ventas.control.repository.ProductoRepository;
import com.ventas.control.repository.TipoProductoRepository;
import com.ventas.control.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {

    @Autowired
    private TipoProductoRepository repository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public TipoProducto getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Page<TipoProducto> getByPage(TipoProductoRequestDTO request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by("nombre").ascending());

        Page<TipoProducto> response = repository.getByPage(request.getTipoProducto().getId(), request.getTipoProducto().getId() == null ? 0l : request.getTipoProducto().getId(),
                request.getTipoProducto().getCodigo(), request.getTipoProducto().getCodigo() == null ? "" : request.getTipoProducto().getCodigo(),
                request.getTipoProducto().getNombre(), request.getTipoProducto().getNombre() == null ? "" : request.getTipoProducto().getNombre(),
                pageable);
        return response;
    }

    @Override
    public TipoProducto save(TipoProducto obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Long id) {
        TipoProducto obj = getById(id);
        if (obj != null) {
            repository.delete(obj);
        }
    }

    @Override
    public String getUniqueValidator(TipoProductoRequestDTO requestDTO) {

        if (null != requestDTO && null != requestDTO.getTipoProducto()) {
            TipoProducto tp = repository.getByCodigo(requestDTO.getTipoProducto().getCodigo());
            if (null != tp && (tp.getId() != requestDTO.getTipoProducto().getId())){
                return "El código ingresado ya se encuentra registrado";
            }

            TipoProducto tp2 = repository.getByNombre(requestDTO.getTipoProducto().getNombre());
            if (null != tp2 && (tp2.getId() != requestDTO.getTipoProducto().getId())){
                return "El nombre ingresado ya se encuentra registrado";
            }
        }
        return null;
    }

    @Override
    public List<TipoProducto> getAll() {
        return repository.findAll(Sort.by("nombre").ascending());
    }

}
