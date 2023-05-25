package supermercado.interfaces;

import java.util.List;

public interface GenericInterface<T, V> {
     void imprimir();

     void add(T t, V v);

     void delete(T t, V v);

     void update(T t);

     boolean isExist(T t);
}
