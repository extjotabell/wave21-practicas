package com.example.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
