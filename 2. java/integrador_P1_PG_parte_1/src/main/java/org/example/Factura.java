package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    int idFactura;
    int idCliente;
    int total;
    List<String> items = new ArrayList<>();

    public Factura(int idFactura, int idCliente, int total, List<String> items) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.total = total;
        this.items = items;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", idCliente=" + idCliente +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
