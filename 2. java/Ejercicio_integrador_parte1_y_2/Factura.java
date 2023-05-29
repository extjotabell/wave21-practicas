package Ejercicio_integrador_parte1;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> list;
    private double total;

    public Factura(Cliente cliente, ArrayList<Item> list, double total) {
        this.cliente = cliente;
        this.list = list;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getList() {
        return list;
    }

    public void setList(ArrayList<Item> list) {
        this.list = list;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {

        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", list=" + list +
                ", total=" + total +
                '}';
    }
}
