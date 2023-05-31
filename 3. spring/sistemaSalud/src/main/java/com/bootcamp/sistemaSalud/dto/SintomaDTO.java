package com.bootcamp.sistemaSalud.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private int nivel_gravedad;

}
