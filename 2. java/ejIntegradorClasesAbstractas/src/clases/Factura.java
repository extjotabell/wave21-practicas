package clases;

import java.util.List;
import java.util.stream.Collectors;

public class Factura {
    private List<Cliente> clientes;
    private List<Item> items;
    private Double total;

    public Factura(List<Cliente> clientes, List<Item> items) {
        this.clientes = clientes;
        this.items = items;
        this.total = getTotal();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setCliente(Cliente cliente) {
        if(!this.clientes.contains(cliente)){
            this.clientes.add(cliente);
        }else if(this.clientes.contains(cliente)){

        }else{
            this.clientes.add(cliente);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return this.items.stream().map(item -> item.getCostoUnitario()*item.getCantidad()).reduce((item, item2) -> item+item2).orElse(0d);
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "clientes=" + clientes +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
