package com.example.generico.DTO;

import com.example.generico.entity.Persona;
import com.example.generico.entity.Sintoma;

public record PersonaDTO (String nombre, String apellido, int edad) {
  public PersonaDTO(Persona p) {
    this(p.getNombre(), p.getApellido(), p.getEdad());
  }
}
