package org.example;

public class Vehiculo {

  private String modelo;
  private String marca;

  private Double precio;

  public Vehiculo(String modelo, String marca, Double precio) {
    this.marca = marca;
    this.modelo = modelo;
    this.precio = precio;
  }

  public Double getPrecio() {
    return this.precio;
  }

  public String getMarca() {
    return this.marca;
  }

  public String getModelo() {
    return modelo;
  }

  @Override
  public String toString() {
    return "Vehiculo{" +
      "modelo='" + modelo + '\'' +
      ", marca='" + marca + '\'' +
      ",  = $" + precio +
      '}';
  }

}
