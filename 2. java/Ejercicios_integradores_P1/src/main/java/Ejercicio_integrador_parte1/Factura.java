package Ejercicio_integrador_parte1;

import java.util.Arrays;

public class Factura {
    private Cliente cliente;
    private double[] list;
    private double total;

    public Factura(Cliente cliente, double[] list, double total) {
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

    public double[] getList() {
        return list;
    }

    public void setList(double[] list) {
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
                ", list=" + Arrays.toString(list) +
                ", total=" + total +
                '}';
    }
}
