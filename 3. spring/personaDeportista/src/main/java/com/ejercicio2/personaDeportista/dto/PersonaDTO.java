package com.ejercicio2.personaDeportista.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}