import java.util.List;

public interface Repository <T>{
    T findBy(String id);
    void save(T obj);
    List<T> findAll();
}
