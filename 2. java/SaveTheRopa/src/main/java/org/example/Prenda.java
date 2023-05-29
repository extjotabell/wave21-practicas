package org.example;

public class Prenda {

  String marca;
  String modelo;

  public Prenda(String marca, String modelo) {
    this.marca = marca;
    this.modelo = modelo;
  }

  @Override
  public String toString() {
    return String.format("La prenda es de marca %s y modelo: %s ", this.marca, this.modelo);
  }
}
