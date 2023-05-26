package el_economista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioClientes implements CRUD<Cliente> {

    private List<Cliente> clientes;
    private int nextId;

    public RepositorioClientes() {
        this.clientes = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public Cliente getElemento(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<Cliente> getElementos() {
        return Collections.unmodifiableList(this.clientes);
    }

    @Override
    public boolean existeElemento(Cliente elem) {
        return this.clientes.contains(elem);
    }

    @Override
    public void agregarElemento(Cliente elem) {
        elem.setId(this.nextId++);
        this.clientes.add(elem);
    }

    @Override
    public Cliente modificarElemento(Cliente nuevoElem) {
        Cliente clienteViejo = this.getElemento(nuevoElem.getId());
        int indexOfCliente = this.clientes.indexOf(clienteViejo);
        this.clientes.set(indexOfCliente, nuevoElem);
        return this.clientes.get(indexOfCliente);
    }

    @Override
    public void removerElemento(Cliente elem) {
        this.clientes.remove(elem);
    }
}
