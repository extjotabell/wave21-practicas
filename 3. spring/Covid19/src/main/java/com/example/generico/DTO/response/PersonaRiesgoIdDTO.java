package com.example.generico.DTO.response;

import com.example.generico.entity.PersonaRiesgo;

public record PersonaRiesgoIdDTO(Integer id) {
  public PersonaRiesgoIdDTO(PersonaRiesgo p) {
    this(p.getId());
  }
}
