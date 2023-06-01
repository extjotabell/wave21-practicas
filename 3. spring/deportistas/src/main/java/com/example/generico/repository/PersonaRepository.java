package com.example.generico.repository;

import com.example.generico.entity.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaRepository {
  private static final List<Persona> personas = new ArrayList<>();

  public static Persona save(Persona p) {
    personas.add(p);
    p.setId(personas.size()-1);
    return p;
  }

  public static Optional<Persona> findById(Integer id) {
    return Optional.ofNullable(personas.get(id));
  }

  public static List<Persona> get() {
    return personas;
  }
}
