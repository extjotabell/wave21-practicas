package com.example.generico.repository;

import com.example.generico.entity.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaRepository {
  private static final int EDAD_RIESGO = 60;
  public static final List<Persona> personas = new ArrayList<>();

  public static Persona save(Persona p) {
    p.setId(personas.size());
    personas.add(p);
    return p;
  }
  public static Optional<Persona> getById(Integer id) {
    return Optional.ofNullable(personas.get(id));
  }

  public static List<Persona> buscarPersonaRiesgo() {
    return personas
      .stream()
      .filter(p -> p.getEdad() > EDAD_RIESGO)
      .toList();
  }
}
