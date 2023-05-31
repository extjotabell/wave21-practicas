package com.practicaSpring.ejercicioDeportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeporteXPersonaDTO {

    private String nombre;
    private String apellido;
    private String deporte;
}
