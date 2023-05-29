package org.parteI.model;

import org.parteI.logic.iCrudCliente;

import java.util.List;

public class Factura {
    private long codigo;
    private Cliente cliente;
    private List<Item> listaProducto;
    private double totalCompra;

    public Factura(long codigo, Cliente cliente, List<Item> listaProducto, double totalCompra) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaProducto = listaProducto;
        this.totalCompra = totalCompra;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Item> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", listaProducto=" + listaProducto +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
