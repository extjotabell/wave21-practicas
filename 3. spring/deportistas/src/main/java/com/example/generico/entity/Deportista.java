package com.example.generico.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deportista {
  private Integer id;
  private Persona persona;
  private Deporte deporte;

  public Deportista(Persona p, Deporte d) {
    this.persona = p;
    this.deporte = d;
  }
}
