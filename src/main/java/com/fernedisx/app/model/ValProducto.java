package com.fernedisx.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
public class ValProducto {

    private Integer id_producto;

    @NotEmpty(message = "El campo no debe ser vacio")
    private String codigo;

    @NotEmpty(message = "El campo no debe ser vacio")
    @Size(min = 5, max = 100)
    private String descripcion;

    @NotEmpty(message = "El campo no debe ser vacio")
    @Min(1)
    private Double precio;

    @NotEmpty(message = "El campo no debe ser vacio")
    @Min(1)
    private int Cantidad;
}
