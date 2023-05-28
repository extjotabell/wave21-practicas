package models;

import java.util.List;

public class Factura {
    private Cliente datosCliente;
    private double total;
    private List<Producto> listProductos;

    public Factura(Cliente datosCliente, double total, List<Producto> listProductos) {
        this.datosCliente = datosCliente;
        this.total = total;
        this.listProductos = listProductos;
    }

    public Cliente getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(Cliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }
}
