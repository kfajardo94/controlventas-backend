package com.ventas.control.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;
    @Column(length = 50)
    private String codigo;
    @Column(length = 1)
    private String tipo;
    @Column(length = 300)
    private String descripcion;
    @Column()
    private Date fecha;
    @Column()
    private Double total;

}
