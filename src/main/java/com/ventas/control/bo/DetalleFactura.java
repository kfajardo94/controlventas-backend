package com.ventas.control.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "detalle_facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;
    @ManyToOne
    @JoinColumn(name="factura_id")
    private Factura factura;
    @Column(name="producto_codigo")
    private String productoCodigo;
    @Column(name="producto_nombre")
    private String productoNombre;
    @Column(length = 10)
    private Long cantidad;
    @Column()
    private Double total;

}
