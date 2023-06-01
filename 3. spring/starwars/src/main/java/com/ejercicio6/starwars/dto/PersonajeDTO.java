package com.ejercicio6.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PersonajeDTO {
    private String nombre;
    private Integer peso;
    private Integer masa;
    private String genero;
    private String especie;
}
