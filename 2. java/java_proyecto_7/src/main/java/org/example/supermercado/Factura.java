package org.example.supermercado;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private double total;
    private List<Item> items;

    public Factura(Cliente cliente, double total, List<Item> items) {
        this.cliente = cliente;
        this.total = total;
        this.items = items;
    }
}
