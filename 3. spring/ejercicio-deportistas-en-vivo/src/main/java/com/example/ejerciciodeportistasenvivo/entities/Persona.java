package com.example.ejerciciodeportistasenvivo.entities;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}