package com.covid19.covid.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO {

    private String nombre;
    private String apellido;

    public PersonaDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
