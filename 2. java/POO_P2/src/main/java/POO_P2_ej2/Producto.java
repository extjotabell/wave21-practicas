package POO_P2_ej2;

public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double calcular(int cantidadDeProductos){
        return precio * cantidadDeProductos;
    }

    @Override
    public String toString() {
        return "Este producto es " + nombre + " y cuesta " + precio;
    }
}
