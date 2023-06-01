package com.example.generico.entity;

import com.example.generico.DTO.PersonaRiesgoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonaRiesgo {
  Integer id;
  Persona persona;
  List<Sintoma> sintomas = new ArrayList<>();

  public PersonaRiesgo(Persona p, List<Sintoma> s) {
    this.persona = p;
    this.sintomas = s;
  }
}
