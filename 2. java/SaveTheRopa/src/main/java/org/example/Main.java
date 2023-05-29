package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Prenda> prendas = Arrays.asList(
      new Prenda("kevingston", "chomba i23h"),
      new Prenda("adidas", "zapatilla o23g"),
      new Prenda("nike", "pantalon v23m"),
      new Prenda("lacoste", "remera i23h")
    );

    GuardaRopa placard = new GuardaRopa();

    Integer id = placard.guardarPrendas(prendas);

    placard.mostrarPrendas();
    placard.devolverPrenda(id).forEach(System.out::println);
  }
}