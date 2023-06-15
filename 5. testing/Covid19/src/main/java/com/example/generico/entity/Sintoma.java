package com.example.generico.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
  private Integer id;
  private String codigo;
  private String nombre;
  private int gravedad;
}
