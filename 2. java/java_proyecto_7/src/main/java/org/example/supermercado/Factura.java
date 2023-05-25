package org.example.supermercado;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private double total;
    private List<Item> items;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal(items);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setItemsYCalcularTotal(List<Item> items) {
        this.items = items;
        this.total = calcularTotal(items);
    }

    private double calcularTotal(List<Item> items){
        double total = 0;
        for (Item item : items){
            total += (item.getCostoUnitario() * item.getCantidadComprada());
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
