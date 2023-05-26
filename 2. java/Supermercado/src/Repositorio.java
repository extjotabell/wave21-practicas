import java.util.ArrayList;

public class Repositorio<T extends IObtenerId> implements ICrud<T> {
    private ArrayList<T> elementos;

    public Repositorio() {
        this.elementos = new ArrayList<T>();
    }

    @Override
    public void crear(T objeto) {
        if(obtenerUno(objeto.obtenerId()) == null) elementos.add(objeto);
        else actualizar(objeto);
    }

    @Override
    public T obtenerUno(Long id) {
        return elementos.stream().filter(e -> e.obtenerId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public ArrayList<T> obtnerTodos() {
        return elementos;
    }

    @Override
    public void actualizar(T objeto) {
        int index = elementos.indexOf(obtenerUno(objeto.obtenerId()));
        elementos.set(index, objeto);
    }

    @Override
    public void eliminar(Long id) {
        elementos.removeIf(e -> e.obtenerId().equals(id));
    }
}
