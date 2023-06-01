package com.example.generico.DTO;

import com.example.generico.entity.Persona;

public record PersonaIdDTO(Integer id) {
  public PersonaIdDTO(Persona p) {
    this(p.getId());
  }
}
