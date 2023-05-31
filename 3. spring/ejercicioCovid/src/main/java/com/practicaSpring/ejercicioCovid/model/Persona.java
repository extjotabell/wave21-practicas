package com.practicaSpring.ejercicioCovid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private Sintoma sintoma;
}
