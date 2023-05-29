package com.bootcamp.wave21.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class Factura {
    private Cliente cliente;
    private List<ItemFactura> productos ;
    private double costoTotal;

    public Factura(Cliente cliente, List<ItemFactura> productos) {
        this.cliente = cliente;
        this.productos = productos;

    }

    public Factura() {
        productos = new ArrayList<ItemFactura>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getProductos() {
        return productos;
    }

    public void setProductos(List<ItemFactura> productos) {
        this.productos = productos;
    }

    public double getCostoTotal() {

        return this.costoTotal;
    }

    public void calcularCosto(){
        this.costoTotal = this.getProductos().stream().mapToDouble(n->n.getCantComprada()*n.getCostoUnitario()).sum();
    }
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Factura" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", costoTotal=" + costoTotal ;

    }

    public void agregarProducto(ItemFactura item){
        productos.add(item);
    }


    public void mostrarProductos(){
        for(ItemFactura fact : productos){
            System.out.println(fact.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura)) return false;

        Factura factura = (Factura) o;

        if (Double.compare(factura.costoTotal, costoTotal) != 0) return false;
        if (cliente != null ? !cliente.equals(factura.cliente) : factura.cliente != null) return false;
        return productos != null ? productos.equals(factura.productos) : factura.productos == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cliente != null ? cliente.hashCode() : 0;
        result = 31 * result + (productos != null ? productos.hashCode() : 0);
        temp = Double.doubleToLongBits(costoTotal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
