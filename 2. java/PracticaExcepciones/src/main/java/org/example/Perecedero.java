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

  @Override
  public double calcular(int cantidadDeProductos) {
    if(this.diasPorCaducar == 1)
      return this.getPrecio()*cantidadDeProductos*0.25;
    if(this.diasPorCaducar == 2)
      return this.getPrecio()*cantidadDeProductos*0.333;
    if(this.diasPorCaducar == 3)
      return this.getPrecio()*cantidadDeProductos*0.5;

    return 0d;
  }

  public String toString() {
    return "Producto: "+this.getNombre()+" a $"+this.getPrecio();
  }

}
