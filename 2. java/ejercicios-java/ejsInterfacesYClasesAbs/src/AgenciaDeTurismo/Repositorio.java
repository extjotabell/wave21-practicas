package AgenciaDeTurismo;

public interface Repositorio<T> {
     public void search(T obj);
     public void agregarAlRepositorio(T obj);
}
