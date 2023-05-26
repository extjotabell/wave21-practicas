package el_economista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioFacturas implements CRUD<Factura>{

    private List<Factura> facturas;
    private int nextId;

    public RepositorioFacturas() {
        this.facturas = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public Factura getElemento(int id) {
        return facturas.stream().filter(c -> c.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<Factura> getElementos() {
        return Collections.unmodifiableList(this.facturas);
    }

    @Override
    public boolean existeElemento(Factura elem) {
        return this.facturas.contains(elem);
    }

    @Override
    public void agregarElemento(Factura elem) {
        elem.setId(this.nextId++);
        this.facturas.add(elem);
    }

    @Override
    public Factura modificarElemento(Factura nuevoElem) {
        Factura facturaVieja = this.getElemento(nuevoElem.getId());
        int indexOfFactura = this.facturas.indexOf(facturaVieja);
        this.facturas.set(indexOfFactura, nuevoElem);
        return this.facturas.get(indexOfFactura);
    }

    @Override
    public void removerElemento(Factura elem) {
        this.facturas.remove(elem);
    }
}
