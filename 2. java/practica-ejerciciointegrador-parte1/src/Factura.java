import java.util.Map;

public class Factura {

    Cliente cliente;
    Map<Item,Integer> productos;
    Double total;

    public Factura(Cliente cliente, Map<Item,Integer> productos, Double total) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map<Item,Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<Item,Integer> productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
