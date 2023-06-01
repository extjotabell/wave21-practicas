package com.bootcamp.ejercicioDeportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;
}
