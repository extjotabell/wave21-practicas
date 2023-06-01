package com.example.ejercicioDeportistasDTO.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

}
