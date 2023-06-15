package com.example.generico.DTO;

import com.example.generico.entity.Sintoma;

public record SintomaIdDTO(Integer id) {
  public SintomaIdDTO(Sintoma s) {
    this(s.getId());
  }
}
