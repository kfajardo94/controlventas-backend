package com.ventas.control.impl;

import com.ventas.control.bo.DetalleFactura;
import com.ventas.control.bo.Factura;
import com.ventas.control.bo.Producto;
import com.ventas.control.bo.Stock;
import com.ventas.control.dto.DetalleFacturaRequestDTO;
import com.ventas.control.repository.DetalleFacturaRepository;
import com.ventas.control.repository.FacturaRepository;
import com.ventas.control.repository.ProductoRepository;
import com.ventas.control.repository.StockRepository;
import com.ventas.control.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository repository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public DetalleFactura getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Page<DetalleFactura> getPageByFactura(DetalleFacturaRequestDTO request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        Page<DetalleFactura> response = repository.getPageByFactura(request.getFactura(),
                pageable);
        return response;
    }

    @Override
    public List<DetalleFactura> getByFactura(DetalleFacturaRequestDTO request) {

        List<DetalleFactura> response = repository.getByFactura(request.getFactura());
        return response;
    }

    @Override
    public void save(DetalleFacturaRequestDTO requestDTO) {
        if (null != requestDTO && null != requestDTO.getLstDetalle() && requestDTO.getLstDetalle().size() > 0){
            for (DetalleFactura obj : requestDTO.getLstDetalle()) {

                Producto producto = productoRepository.getByCodigo(obj.getProductoCodigo());
                if (null != producto) {
                    Stock stock = stockRepository.getByProducto(producto);
                    if (null != obj.getFactura() && obj.getFactura().getTipo().equals("C")) {
                        if (null != stock) {
                            stock.setCantidad(stock.getCantidad()+obj.getCantidad());
                        } else {
                            stock = new Stock(null, producto, obj.getCantidad());
                        }
                    } else if (null != obj.getFactura() && obj.getFactura().getTipo().equals("V")) {
                        if (null != stock) {
                            stock.setCantidad(stock.getCantidad()-obj.getCantidad());
                            if (stock.getCantidad() <= 0) {
                                stockRepository.delete(stock);
                            }
                        }
                    }
                    stockRepository.save(stock);
                }
                repository.save(obj);
            }
        }
    }

    @Override
    public void delete(Long id) {
        DetalleFactura obj = getById(id);
        if (obj != null) {
            repository.delete(obj);
        }
    }

}
