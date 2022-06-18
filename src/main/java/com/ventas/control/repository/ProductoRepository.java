package com.ventas.control.repository;

import com.ventas.control.bo.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto getById(Long id);

    @Query("SELECT new com.ventas.control.bo.Producto(p.id, p.nombre, p.codigo, p.descripcion, p.imagen, p.precio, p.tipoProducto) " +
            "FROM Producto p " +
            "WHERE (?1 is null or CAST(p.id as string) LIKE %?2%) " +
            "and (?3 is null or p.codigo like %?4%) " +
            "and (?5 is null or p.nombre like %?6%)")
    Page<Producto> getByPage(Long idSource, Long id, String codigoSource, String codigo, String nombreSource, String nombre, Pageable pageable);

    Producto getByNombre(String nombre);
    Producto getByCodigo(String codigo);

}
