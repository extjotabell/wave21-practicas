package com.example.generico.repository;

import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class PersonaRiesgoRepository {
  public static final List<PersonaRiesgo> personas = new ArrayList<>();

  public static List<PersonaRiesgo> findBySintoma(String sintoma) {
    return personas
      .stream()
      .filter(
        pr -> pr.getSintomas()
          .stream()
          .map(Sintoma::getNombre)
          .anyMatch(n -> n.equals(sintoma))
      ).toList();
  }

  public static PersonaRiesgo save(PersonaRiesgo pr) {
    pr.setId(personas.size());
    personas.add(pr);

    return pr;
  }
  public static List<PersonaRiesgo> getAll() {
    return personas;
  }

}
