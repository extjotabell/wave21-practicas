package org.example.repositorios;

import java.util.Optional;

public interface Repositorio<T> {

  void add(T obj);
  Optional<T> search(T obj);
}
