package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<Cliente> clientes = new ArrayList<>(){{
      add(new Cliente(1, "Nahuel", "De Bellis"));
      add(new Cliente(2, "Nahuel", "De Bellis"));
      add(new Cliente(3, "Nahuel", "De Bellis"));
    }};

    clientes.forEach(System.out::println);
    System.out.println("Eliminando...");
    clientes.remove(0);
    clientes.forEach(System.out::println);

    Scanner s = new Scanner(System.in);
    int search = s.nextInt();

    clientes
      .stream()
      .filter(c -> c.getDni() == search)
      .findFirst()
      .ifPresentOrElse(
        System.out::println,
        () -> System.out.println("No se encontro el dni: "+search)
      );

    System.out.println("Listado final");
    clientes.forEach(System.out::println);
  }
}