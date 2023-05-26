package Ejercicio;

public interface CRUD <T>{
    boolean agregarElemento(T elemento);
    boolean eliminarElemento (String elemento);
    boolean actualizarElemento (T elemento);
    T consultarElemento (String elemento);
}
