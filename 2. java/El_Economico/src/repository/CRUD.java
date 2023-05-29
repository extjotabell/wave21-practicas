package repository;

import java.util.Optional;

public interface CRUD<T>{
    public void save(T obj);
    public void delete(Integer id);
    public Optional<T> update(T obj);
    public void read();
    public Optional<T> search(Integer id);

}
