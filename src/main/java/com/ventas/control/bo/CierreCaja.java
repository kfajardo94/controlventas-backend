package com.ventas.control.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cierre_caja")
@Getter
@Setter
@NoArgsConstructor
public class CierreCaja {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;
    @Column()
    private Date fecha;
    @Column()
    private Double saldoAnterior;
    @Column()
    private Double saldoCierre;
    @Column()
    private Date fechaHoraCierre;

    public CierreCaja(Long id, Date fecha, Double saldoAnterior, Double saldoCierre, Date fechaHoraCierre) {
        this.id = id;
        this.fecha = fecha;
        this.saldoAnterior = saldoAnterior;
        this.saldoCierre = saldoCierre;
        this.fechaHoraCierre = fechaHoraCierre;
    }
}
