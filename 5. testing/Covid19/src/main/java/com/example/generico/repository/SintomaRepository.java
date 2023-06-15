package com.example.generico.repository;

import com.example.generico.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SintomaRepository {
  private static final List<Sintoma> sintomas = new ArrayList<>();

  public Sintoma save(Sintoma s) {
    s.setId(sintomas.size());
    sintomas.add(s);

    return s;
  }
  public List<Sintoma> getAll() {
    return sintomas;
  }

  public Optional<Sintoma> getByName(String name) {
    return sintomas
      .stream()
      .filter(s -> s.getNombre().equals(name))
      .findFirst();
  }

  public List<Sintoma> obtenerSintomas(List<Integer> sintomasIds) {

    return sintomasIds
      .stream()
      .map(SintomaRepository.sintomas::get)
      .toList();
  }
}
