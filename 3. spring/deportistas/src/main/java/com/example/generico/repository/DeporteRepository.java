package com.example.generico.repository;

import com.example.generico.entity.Deporte;
import com.example.generico.entity.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeporteRepository {
  private static final List<Deporte> deportes = new ArrayList<>();

  public static Deporte save(Deporte d) {
    deportes.add(d);
    d.setId(deportes.size()-1);
    return d;
  }

  public static Optional<Deporte> findById(Integer id) {
    return Optional.ofNullable(deportes.get(id));
  }

  public static List<Deporte> get() {
    return deportes;
  }
}
