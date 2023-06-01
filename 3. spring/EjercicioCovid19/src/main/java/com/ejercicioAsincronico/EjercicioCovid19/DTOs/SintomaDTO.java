package com.ejercicioAsincronico.EjercicioCovid19.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;
}
