package com.example.generico.repository;

import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;

import java.util.ArrayList;
import java.util.List;

public class PersonaRiesgoRepository {
  public static final List<PersonaRiesgo> personas = new ArrayList<>();

  public static PersonaRiesgo save(PersonaRiesgo pr) {
    pr.setId(personas.size()-1);
    personas.add(pr);

    return pr;
  }

}
