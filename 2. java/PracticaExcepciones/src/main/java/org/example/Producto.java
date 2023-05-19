package org.example;

public class Producto {
  private String nombre;
  private double precio;

  public Producto(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }

  public double calcular(int cantidadDeProductos) {
    return this.precio*cantidadDeProductos;
  }

  public String getNombre() {
    return this.nombre;
  }

  public double getPrecio() {
    return this.precio;
  }

}
