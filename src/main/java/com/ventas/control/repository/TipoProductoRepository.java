package com.ventas.control.repository;

import com.ventas.control.bo.TipoProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {

    TipoProducto getById(Long id);

    @Query("SELECT new com.ventas.control.bo.TipoProducto(tp.id, tp.nombre, tp.codigo, tp.descripcion) " +
            "FROM TipoProducto tp " +
            "WHERE (?1 is null or CAST(tp.id as string) LIKE %?2%) " +
            "and (?3 is null or tp.codigo like %?4%) " +
            "and (?5 is null or tp.nombre like %?6%)")
    Page<TipoProducto> getByPage(Long idSource, Long id, String codigoSource, String codigo, String nombreSource, String nombre, Pageable pageable);

    TipoProducto getByNombre(String nombre);
    TipoProducto getByCodigo(String codigo);

}
