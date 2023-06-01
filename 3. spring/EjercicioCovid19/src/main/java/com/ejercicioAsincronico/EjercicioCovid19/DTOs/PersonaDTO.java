package com.ejercicioAsincronico.EjercicioCovid19.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
}
