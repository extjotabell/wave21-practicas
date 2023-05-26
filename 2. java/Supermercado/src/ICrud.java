import java.util.ArrayList;

public interface ICrud<T> {
    void crear(T objeto);
    T obtenerUno(Long id);
    ArrayList<T> obtnerTodos();
    void actualizar(T objeto);
    void eliminar(Long id);
}
