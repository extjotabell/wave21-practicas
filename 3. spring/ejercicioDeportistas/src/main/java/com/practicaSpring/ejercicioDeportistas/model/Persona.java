package com.practicaSpring.ejercicioDeportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;

}
