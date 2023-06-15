package com.example.generico.repository;

import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRiesgoRepository {
  public final List<PersonaRiesgo> personas = new ArrayList<>();

  public List<PersonaRiesgo> findBySintoma(String sintoma) {
    return personas
      .stream()
      .filter(
        pr -> pr.getSintomas()
          .stream()
          .map(Sintoma::getNombre)
          .anyMatch(n -> n.equals(sintoma))
      ).toList();
  }

  public PersonaRiesgo save(PersonaRiesgo pr) {
    pr.setId(personas.size());

    personas.add(pr);

    return pr;
  }

  public List<PersonaRiesgo> getAll() {
    return personas;
  }

}
