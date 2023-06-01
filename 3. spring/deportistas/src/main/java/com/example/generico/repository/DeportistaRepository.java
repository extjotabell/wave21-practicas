package com.example.generico.repository;


import com.example.generico.entity.Deportista;
import com.example.generico.entity.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeportistaRepository {
  private static final List<Deportista> deportistas = new ArrayList<>();

  public static Deportista save(Deportista d) {
    deportistas.add(d);
    d.setId(deportistas.size()-1);
    return d;
  }

  public static Optional<Deportista> findById(Integer id) {
    return Optional.ofNullable(deportistas.get(id));
  }

  public static List<Deportista> get() {
    return deportistas;
  }
  public static List<Persona> filterDeportistas() {
    return get()
      .stream()
      .map(d -> d.getPersona())
      .toList();
  }
}
