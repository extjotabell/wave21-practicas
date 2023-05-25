package supermercado.wrappers;

import supermercado.Cliente;
import supermercado.Item;

import java.util.List;

public class ClientItemsWrapper {
    private Cliente cliente;
    private List<Item> items;

    public ClientItemsWrapper(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
