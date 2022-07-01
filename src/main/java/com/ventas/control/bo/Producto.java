package com.ventas.control.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 20)
    private String codigo;
    @Column(length = 300)
    private String descripcion;
    @Column()
    private byte[] imagen;
    @Column()
    private Double precio;
    @ManyToOne
    @JoinColumn(name="tipo_producto_id")
    private TipoProducto tipoProducto;
    @Transient
    private String imagenStr;

    public Producto(Long id, String nombre, String codigo, String descripcion, byte[] imagen, Double precio, TipoProducto tipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }
}
