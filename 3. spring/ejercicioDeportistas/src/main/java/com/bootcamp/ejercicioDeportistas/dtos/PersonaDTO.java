package com.bootcamp.ejercicioDeportistas.dtos;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;

}
