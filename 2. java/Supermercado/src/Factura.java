import java.util.ArrayList;

public class Factura implements  IObtenerId{
    private Long codigo;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private double total;

    public Factura(Long codigo, Cliente cliente, ArrayList<Producto> productos, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
    }

    public Long getCodigo(){return this.codigo;}
    public void setCodigo(Long codigo){this.codigo = codigo;}
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
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
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }

    @Override
    public Long obtenerId() {
        return this.codigo;
    }
}
