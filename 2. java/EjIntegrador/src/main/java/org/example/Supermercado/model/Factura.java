package org.example.Supermercado.model;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;


    public Factura(Cliente cliente, List<Item> items, double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Factura() {
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
