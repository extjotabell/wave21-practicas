package repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T> {

    public void save(T obj);
    public void mostrarPantalla();
    public Optional<T> buscar(Long id);
    public void eliminar(Long id);
    public List<T> traerTodos();
}
