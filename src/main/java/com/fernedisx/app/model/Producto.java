package com.fernedisx.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer id_producto;

    @NonNull
    @Column(name="codigo")
    private String codigo;

    @NonNull
    @Size(min = 5, max = 100)
    @Column(name="descripcion")
    private String descripcion;

    @NonNull
    @Min(1)
    @Column(name="precio")
    private Double precio;

    @NonNull
    @Min(1)
    @Column(name="Cantidad")
    private int Cantidad;
}
