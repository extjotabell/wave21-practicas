package org.example;

import java.util.Map;

public class Perecedero extends Producto {
  private int diasPorCaducar;

  public Perecedero(String nombre, double precio, int diasPorCaducar) {
    super(nombre, precio);
    this.diasPorCaducar = diasPorCaducar;
  }

  public int getDiasPorCaducar() {
    return diasPorCaducar;
  }

  public String toString() {
    return "Product: "+this.getNombre()+". A: $"+this.getPrecio();
  }

  @Override
  public double calcular(int cantidadDeProductos) {
    if(this.diasPorCaducar == 1)
      return this.getPrecio()*0.25;
    if(this.diasPorCaducar == 2)
      return this.getPrecio()*0.33;
    if(this.diasPorCaducar == 3) {}
      return this.getPrecio()-this.getPrecio()*0.5;
  }
}
