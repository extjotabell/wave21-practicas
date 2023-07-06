package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record MiniSerieDTO(
  @NotNull(message = "Missing serie's name")
  String name,
  @NotNull(message = "Missing serie's awards")
  @PositiveOrZero(message = "The numbers of awards cannot be negative")
  int awards,
  double rating
) { }
