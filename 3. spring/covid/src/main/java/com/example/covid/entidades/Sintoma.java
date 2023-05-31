package com.example.covid.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class Sintoma {

    UUID codigo;

    String nombre;

    Integer nivel_de_gravedad;

    public Sintoma() {
        this.codigo = UUID.randomUUID();
    }

}
