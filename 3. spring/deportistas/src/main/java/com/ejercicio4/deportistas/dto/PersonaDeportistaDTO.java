package com.ejercicio4.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDeportistaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
