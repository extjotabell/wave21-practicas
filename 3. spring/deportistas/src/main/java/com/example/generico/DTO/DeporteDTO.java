package com.example.generico.DTO;

import com.example.generico.entity.Deporte;
import com.example.generico.entity.Deportista;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record DeporteDTO (Integer id, String nombre, String nivel) {
  public DeporteDTO(Deporte d) {
    this(d.getId(), d.getNombre(), d.getNivel());
  }

  public DeporteDTO(Deportista deportista) {
    this(deportista.getDeporte());
  }
}
