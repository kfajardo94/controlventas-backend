package com.ventas.control.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tipoProducto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoProducto {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 20)
    private String codigo;
    @Column(length = 300)
    private String descripcion;

    @Override
    public String toString() {
        return "TipoProducto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
