package com.example.ejerciciodeportistasenvivo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaResponseDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
