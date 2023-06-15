package com.example.generico.repository;

import com.example.generico.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepository {
  private static final int EDAD_RIESGO = 60;
  public static final List<Persona> personas = new ArrayList<>();

  public Persona save(Persona p) {
    p.setId(personas.size());
    personas.add(p);
    return p;
  }
  public Optional<Persona> getByIdRiesgo(Integer id) {
    return Optional.ofNullable(personas.get(id))
      .filter(e -> e.getEdad() > EDAD_RIESGO);
  }

  public List<Persona> buscarPersonaRiesgo() {
    return personas
      .stream()
      .filter(p -> p.getEdad() > EDAD_RIESGO)
      .toList();
  }
}
