package PracticaPOO_Vivo2;

public class Producto {
    private String nombre;
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public Producto() {
    }

    @Override
    public String toString() {
        return "El nombre del producto es de: " + this.getNombre() + " y su precio es de: " + this.getPrecio();
    }

    public int calcular(int cantidadDeProductos) {
        int total = (int)(this.getPrecio() * cantidadDeProductos);
        return total;
    }
}
