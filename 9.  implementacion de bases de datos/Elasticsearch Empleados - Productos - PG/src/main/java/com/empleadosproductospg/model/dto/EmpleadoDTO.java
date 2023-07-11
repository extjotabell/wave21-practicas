package com.empleadosproductospg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EmpleadoDTO {
    private String id;
    private String nombre;
    private String apellido;
    private String edad;
    private String ciudad;
}