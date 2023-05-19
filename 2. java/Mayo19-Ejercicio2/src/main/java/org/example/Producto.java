package org.example;

public class Producto {

    public String nombre;
    public double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

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

    public double calcular(int cantidadDeProductos) {
        return cantidadDeProductos * precio;
    }

}
