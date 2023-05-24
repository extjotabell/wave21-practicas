package org.example.repositorios;

import org.example.reservas.Reservas;

import java.util.List;
import java.util.Optional;

public class ReservasRepositorio implements Repositorio<Reservas> {
  List<Reservas> reservas;
  @Override
  public void add(Reservas obj) {
    reservas.add(obj);
  }

  @Override
  public Optional<Reservas> search(Reservas obj) {
    return null;
  }
}
