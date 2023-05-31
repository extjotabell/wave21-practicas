package com.example.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Deporte {
    private String nombre;
    private String nivel;

    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
