package com.example.generico.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sintoma {
  private Integer id;
  private String codigo;
  private String nombre;
  private int gravedad;
}
