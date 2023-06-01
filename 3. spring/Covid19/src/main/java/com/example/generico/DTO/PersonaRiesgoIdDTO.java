package com.example.generico.DTO;

import com.example.generico.entity.PersonaRiesgo;

public record PersonaRiesgoIdDTO(Integer id) {
  public PersonaRiesgoIdDTO(PersonaRiesgo p) {
    this(p.getId());
  }
}
