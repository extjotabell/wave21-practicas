package Ejercicio;

public interface CRUD <T, V>{
    boolean agregarElemento(T elemento);
    boolean eliminarElemento (V elemento);
    boolean actualizarElemento (T elemento);
    T consultarElemento (V elemento);
}
