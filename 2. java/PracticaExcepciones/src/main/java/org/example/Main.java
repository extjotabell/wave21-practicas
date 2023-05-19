package org.example;

import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    try {
      PracticaExcepciones e = new PracticaExcepciones(0, 300);
      double cociente = e.cociente();
    } catch(IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    List<Producto> productos = Arrays.asList(
      new NoPerecedero("Arroz", 500d, "Comida"),
      new NoPerecedero("Galletitas", 200d, "Dulce"),
      new NoPerecedero("Galletitas", 200d, "Dulce"),
      new NoPerecedero("Galletitas", 200d, "Dulce"),
      new NoPerecedero("Galletitas", 200d, "Dulce"),

      new Perecedero("Leche", 1000d, 15),
      new Perecedero("Queso", 1001d, 15),
      new Perecedero("Leche", 1000d, 15),
      new Perecedero("Leche", 1000d, 15),
      new Perecedero("Queso", 1001d, 15),

      new Producto("Pala", 300d),
      new Producto("Pala", 300d),
      new Producto("Pala", 300d),
      new Producto("Pala", 300d),
      new Producto("Pala", 300d)
    );

    double totalProductos = productos
      .stream()
      .map(p -> p.calcular(10))
      .reduce(0d, (t, precio) -> t+precio);

    System.out.println(totalProductos);
  }
}