package com.ventas.control.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;
    @ManyToOne
    @JoinColumn(name="producto_id")
    private Producto producto;
    @Column(length = 10)
    private Integer cantidad;
    @Column()
    private Double precioCompra;
    @Column
    Date fecha;

    public Stock(Long id, Producto producto, Integer cantidad, Double precioCompra, Date fecha) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.fecha = fecha;
    }
}
