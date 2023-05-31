package org.example.Supermercado.repository;

import java.util.List;
import java.util.Optional;

public interface RepoCRUD <T>{

    public void guardar (T objeto);
    public void eliminar (int i);
    public void imprimir();
    public Optional<T> buscarPorID (int id);
}
