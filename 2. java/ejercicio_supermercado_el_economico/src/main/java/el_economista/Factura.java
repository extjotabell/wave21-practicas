package el_economista;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Item> productos;
    private double costoTotal;

    public Factura(Cliente cliente) {
        this.id = 0;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.costoTotal = 0;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
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
        return "\tFactura {" +
                "\n\t\tid= " + getId() +
                ",\n\t\tcliente=" + getCliente() +
                ",\n\t\tproductos=" + getProductos() +
                ",\n\t\tcostoTotal=" + getCostoTotal() +
                "\n\t}";
    }
}
