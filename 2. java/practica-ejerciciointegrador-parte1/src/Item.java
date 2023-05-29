public class Item {
    int id_producto;
    String nombre;
    Double precioUnitario;

    public Item(int id_producto, String nombre, Double precioUnitario) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
