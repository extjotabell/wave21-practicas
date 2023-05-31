package com.bootcamp.sistemaSalud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
