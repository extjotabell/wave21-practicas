package agencia_turismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repositorio<T extends Identificable> {
    private final List<T> elementosAlmacenados;
    private int nextId;

    public Repositorio() {
        this.nextId = 1;
        this.elementosAlmacenados = new ArrayList<>();
    }

    public int agregarElemento(T elem) {
        if (this.elementosAlmacenados.stream().noneMatch(x -> x.getId() == elem.getId())) {
            int actualId = nextId;
            elem.setId(nextId);
            this.elementosAlmacenados.add(elem);
            this.nextId += 1;
            return actualId;
        } else {
            return -1;
        }
    }

    public T getElemento(int id) {
        return this.elementosAlmacenados.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public List<T> getElementos() {
        return Collections.unmodifiableList(this.elementosAlmacenados);
    }
}
