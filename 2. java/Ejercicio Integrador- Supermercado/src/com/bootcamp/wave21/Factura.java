package com.bootcamp.wave21;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<ItemFactura> productos ;
    private double costoTotal;


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

        for(ItemFactura producto : productos){
            this.costoTotal += producto.getCostoUnitario() * producto.getCantComprada();
        }
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
