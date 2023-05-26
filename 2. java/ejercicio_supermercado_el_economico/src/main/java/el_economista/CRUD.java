package el_economista;

import java.util.List;

public interface CRUD <T>{
    T getElemento(int id);
    List<T> getElementos();
    void agregarElemento(T elem);
    T modificarElemento(T nuevoElem);
    void removerElemento(T elem);


}
