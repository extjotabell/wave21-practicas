package org.example.repositorios;

import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositorio {
  private static final List<Cliente> clientes = new ArrayList<>();

  static public void add(Cliente obj) {
    clientes.add(obj);
  }

  static public Optional<Cliente> search(Cliente obj) {
    return clientes.stream().filter(c -> c.equals(obj)).findFirst();
  }
}
