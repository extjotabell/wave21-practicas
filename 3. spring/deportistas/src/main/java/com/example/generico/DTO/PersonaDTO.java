package com.example.generico.DTO;

import com.example.generico.entity.Persona;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record PersonaDTO (Integer id, String nombre, String apellido, int edad) {
  public PersonaDTO(Persona p) {
    this(p.getId(), p.getNombre(), p.getApellido(), p.getEdad());
  }
}
