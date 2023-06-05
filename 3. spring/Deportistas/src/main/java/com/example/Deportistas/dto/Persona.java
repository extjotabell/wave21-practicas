package com.example.Deportistas.dto;

import lombok.Data;

@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;
}
