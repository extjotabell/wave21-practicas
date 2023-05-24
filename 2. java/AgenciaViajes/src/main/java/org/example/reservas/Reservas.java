package org.example.reservas;

public abstract class Reservas {
  String nombre;
  Double monto;

  public Reservas(String nombre, Double monto) {
    this.nombre = nombre;
    this.monto = monto;
  }

  public Double getMonto() {
    return this.monto;
  }

  public String toString() {
    return this.nombre+" original: $"+this.monto;
  }
}
