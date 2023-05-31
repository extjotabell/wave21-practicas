package com.bootcamp.sistemaSalud.entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {

    private String nombre;
    private String codigo;
    private int nivel_de_gravedad;
}
