package EjercicioIntegrador.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {
    void eliminar(String id);
    void agregar(T elemento);
    void modificar(T elemento);
    Optional<T> buscar(String id);
    public List<T> traerTodos();
}
