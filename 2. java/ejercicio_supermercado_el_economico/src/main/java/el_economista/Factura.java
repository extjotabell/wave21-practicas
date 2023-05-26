package el_economista;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> productos;
    private double costoTotal;

    public Factura(Cliente cliente, List<Item> productos, double costoTotal) {
        this.cliente = cliente;
        this.productos = productos;
        this.costoTotal = costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getProductos() {
        return productos;
    }

    public void setProductos(List<Item> productos) {
        this.productos = productos;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", costoTotal=" + costoTotal +
                '}';
    }
}
