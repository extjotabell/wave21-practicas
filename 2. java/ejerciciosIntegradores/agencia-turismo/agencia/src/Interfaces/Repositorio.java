package Interfaces;

import java.util.List;

public interface Repositorio<T> {
    void agregar(T elemento);
    T buscarPorId(String id);
    List<T> obtenerTodos();
}
