package org.example.repositorios;

import org.example.Cliente;
import org.example.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocalizadorRepositorio implements Repositorio<Localizador> {
  public static List<Localizador> localizadores = new ArrayList<>();

  @Override
  public void add(Localizador obj) {
    localizadores.add(obj);
  }

  @Override
  public Optional<Localizador> search(Localizador obj) {
    return LocalizadorRepositorio.localizadores.stream().filter(l -> l.equals(obj)).findFirst();
  }

  static public List<Localizador> searchByClient(Cliente obj) {
    return LocalizadorRepositorio.localizadores.stream().filter(l -> l.getCliente().equals(obj)).toList();
  }
}
