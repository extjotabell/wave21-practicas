package com.ejcovid.ejcovid.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaRiesgoDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String sintoma;




    public PersonaRiesgoDTO(Persona persona,Sintoma sintoma) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.edad = persona.getEdad();
        this.sintoma = sintoma.getNombre();
    }
}


