package com.example.generico.DTO.response;

import com.example.generico.entity.Sintoma;

public record SintomaResponseDTO (Integer id, String codigo, Integer gravedad) {
  public SintomaResponseDTO(Sintoma s) {
    this(s.getId(), s.getCodigo(), s.getGravedad());
  }
}
