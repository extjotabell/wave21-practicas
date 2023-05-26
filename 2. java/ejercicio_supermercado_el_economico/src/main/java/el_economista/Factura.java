package el_economista;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> productos;
    private double costoTotal;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.costoTotal = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getProductos() {
        return productos;
    }

    public void setProductos(List<Item> productos) {
        this.productos = productos;
    }

    public double getCostoTotal() {
        productos.forEach(i -> this.costoTotal += i.getCostoUnitario() * i.getCantidadComprada());
        return costoTotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + getCliente() +
                ", productos=" + getProductos() +
                ", costoTotal=" + getCostoTotal() +
                '}';
    }
}
