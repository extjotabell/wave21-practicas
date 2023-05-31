package com.practicaSpring.ejercicioDeportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Deporte {

    private String nombre;
    private int nivel;

}
