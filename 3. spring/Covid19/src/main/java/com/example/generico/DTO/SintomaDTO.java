package com.example.generico.DTO;

import com.example.generico.entity.Sintoma;

public record SintomaDTO (String nombre, String codigo, Integer gravedad) {
  public SintomaDTO(Sintoma s) {
    this(s.getNombre(), s.getCodigo(), s.getGravedad());
  }
}
