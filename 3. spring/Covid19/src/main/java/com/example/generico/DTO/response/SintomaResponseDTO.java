package com.example.generico.DTO.response;

import com.example.generico.entity.Sintoma;

public record SintomaResponseDTO (String codigo, Integer gravedad) {
  public SintomaResponseDTO(Sintoma s) {
    this(s.getCodigo(), s.getGravedad());
  }
}
