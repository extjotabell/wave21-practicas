package com.covid19.covid.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class SintomaDTO {

    private int codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public SintomaDTO(int codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
