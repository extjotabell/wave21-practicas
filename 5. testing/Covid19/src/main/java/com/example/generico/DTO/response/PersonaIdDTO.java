package com.example.generico.DTO.response;

import com.example.generico.entity.Persona;

public record PersonaIdDTO(Integer id) {
  public PersonaIdDTO(Persona p) {
    this(p.getId());
  }
}
