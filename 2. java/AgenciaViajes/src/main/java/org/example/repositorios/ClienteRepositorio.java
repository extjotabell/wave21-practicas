package org.example.repositorios;

import org.example.Clientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositorio {
  private static final List<Clientes> clientes = new ArrayList<>();

  static public void add(Clientes obj) {
    clientes.add(obj);
  }

  static public Optional<Clientes> search(Clientes obj) {
    return clientes.stream().filter(c -> c.equals(obj)).findFirst();
  }
}
