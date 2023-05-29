import java.util.List;
import java.util.Map;

public class Factura {

    Cliente cliente;
    List<Item> productos;
    Double total;

    public Factura(Cliente cliente,List<Item> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = calcularTotal(productos);
    }
    public Double calcularTotal(List<Item>  productos){
        Double total = 0.0;
        for(Item item : productos){
            total+= item.getPrecioUnitario() * item.getCantidadComprada();
        }
        return total;
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

    public void setProductos(List<Item>  productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
