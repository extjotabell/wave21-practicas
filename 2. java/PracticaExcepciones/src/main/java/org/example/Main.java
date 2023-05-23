package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

  public record Total(String tipo, Double total) { }

  public static void main(String[] args) {
    try {
      PracticaExcepciones e = new PracticaExcepciones(0, 300);

      double cociente = e.cociente();
    } catch(IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    List<Total> totales = new ArrayList<>();
    List<List<Producto>> productos = Arrays.asList(
      Arrays.asList(
        new NoPerecedero("Arroz", 500d, "Comida"),
        new NoPerecedero("Galletitas", 200d, "Dulce"),
        new NoPerecedero("Fideos", 200d, "Pasta"),
        new NoPerecedero("Polenta", 200d, "Comida"),
        new NoPerecedero("Pan", 200d, "Carbohidrato")
      ),
      Arrays.asList(
        new Perecedero("Leche", 1000d, 3),
        new Perecedero("Queso", 1001d, 1),
        new Perecedero("Carne", 1000d, 3),
        new Perecedero("Manteca", 1000d, 2),
        new Perecedero("Queso en fetas", 1001d, 3)
      ),
      Arrays.asList(
        new Producto("Pala", 300d),
        new Producto("Martillo", 300d),
        new Producto("Taladro", 300d),
        new Producto("Motor", 300d),
        new Producto("Caladora", 300d)
      )
    );

    for(List<Producto> p : productos) {
      String tipo = switch (p.get(0)) {
        case Perecedero pp -> "Productos precedero";
        case NoPerecedero pp -> "Productos No Perecedero";
        case Producto pp -> "Productos Genericos";
      };

      totales.add(new Total(tipo, Main.calcularTotal(p)));

      System.out.println("=======================");
    }

    totales.forEach(t -> System.out.printf("El total de los %s es: $%s%n", t.tipo, t.total));
  }

  static public double calcularTotal(List<Producto> products) {
    return products
     .stream()
     .peek(p -> System.out.printf(p.toString()))
     .map(p -> p.calcular(9))
     .peek(n -> System.out.printf(". Total: $"+n+"\n"))
     .reduce(0d, Double::sum);
  }
}