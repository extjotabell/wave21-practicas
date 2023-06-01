package com.example.generico.DTO;


import com.example.generico.entity.Deportista;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record DeportistaDTO (Integer id, PersonaDTO persona, DeporteDTO deporte) {
  public DeportistaDTO (PersonaDTO persona, DeporteDTO deporte) {
    this(null, persona, deporte);
  }
  public DeportistaDTO(Deportista d) {
    this(d.getId(), new PersonaDTO(d.getPersona()), new DeporteDTO(d.getDeporte()));
  }
}
