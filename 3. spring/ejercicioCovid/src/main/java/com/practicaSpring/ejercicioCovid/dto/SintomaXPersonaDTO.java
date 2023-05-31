package com.practicaSpring.ejercicioCovid.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SintomaXPersonaDTO {

    private String nombre;
    private String apellido;
    private String sintoma;
}
