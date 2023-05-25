package interfaces;

import java.util.Collection;

public interface CRUD<T> {
    void create(T object);
    T read(String id);
    void update(T object, String id);
    void delete(T object);
    Collection<T> getAll();
}
