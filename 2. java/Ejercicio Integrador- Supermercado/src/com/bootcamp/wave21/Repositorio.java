package com.bootcamp.wave21;

import java.util.List;

public interface Repositorio<T>{

    T buscar(T obj);
    boolean agregar(T obj);
    boolean eliminar(T obj);
    List<T> buscarTodos();
}
