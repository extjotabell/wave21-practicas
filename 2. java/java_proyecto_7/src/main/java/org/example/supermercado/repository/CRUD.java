package org.example.supermercado.repository;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {

    public void guardar(T objeto);
    public void imprimirPantalla();
    public Optional<T> buscar(String id);
    public void eliminar(String id);
    public List<T> buscarTodos();
}
