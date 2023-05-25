package Ejercicio;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private int totalCompra;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public Factura(Cliente cliente, List<Item> items, int totalCompra) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

}
