package com.example.generico.repository;

import com.example.generico.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SintomaRepository {
  private static final List<Sintoma> sintomas = new ArrayList<>();

  public static Sintoma save(Sintoma s) {
    s.setId(sintomas.size());
    sintomas.add(s);

    return s;
  }
  public static List<Sintoma> getAll() {
    return sintomas;
  }

  public static Optional<Sintoma> getByName(String name) {
    return sintomas
      .stream()
      .filter(s -> s.getNombre().equals(name))
      .findFirst();
  }

  public static List<Sintoma> obtenerSintomas(List<Integer> sintomasIds) {

    return sintomasIds
      .stream()
      .map(SintomaRepository.sintomas::get)
      .toList();
  }
}
