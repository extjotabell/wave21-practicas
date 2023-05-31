package com.ejercicioVivo.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SintomaDTO {
    private String nombre;
    private int codigo;
    private int nivelDeGravedad;

}
