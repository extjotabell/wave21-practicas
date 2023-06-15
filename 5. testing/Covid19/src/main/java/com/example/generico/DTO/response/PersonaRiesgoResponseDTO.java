package com.example.generico.DTO.response;

import com.example.generico.DTO.PersonaDTO;
import com.example.generico.DTO.SintomaDTO;
import com.example.generico.entity.PersonaRiesgo;
import lombok.EqualsAndHashCode;

import java.util.List;

public record PersonaRiesgoResponseDTO (PersonaDTO persona, List<SintomaDTO> sintomas) {
  public PersonaRiesgoResponseDTO(PersonaRiesgo pr) {
    this(
      new PersonaDTO(pr.getPersona()),
      pr.getSintomas()
        .stream()
        .map(SintomaDTO::new)
        .toList()
    );
  }
}
