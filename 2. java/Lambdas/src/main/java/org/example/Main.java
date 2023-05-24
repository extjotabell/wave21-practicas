package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

    Comparator<Vehiculo> precio = Comparator.comparing(Vehiculo::getPrecio);
    Comparator<Vehiculo> marca = Comparator.comparing(Vehiculo::getMarca);
    Comparator<Vehiculo> marcaPrecio = marca.thenComparing(precio);

    List<Vehiculo> vehiculos = Arrays.asList(
      new Vehiculo("Fiesta", "Ford", 1000d),
      new Vehiculo("Kangoo", "Ford", 1200d),
      new Vehiculo("Explorer", "Ford", 2500d),
      new Vehiculo("Uno", "Fiat", 500d),
      new Vehiculo("Cronos", "Fiat", 1000d),
      new Vehiculo("Torino", "Fiat", 1250d),
      new Vehiculo("Aveo", "Chevrolet", 1250d),
      new Vehiculo("Spin", "Chevrolet", 2500d),
      new Vehiculo("Fortuner", "Toyota", 1200d),
      new Vehiculo ("Corola", "Toyota", 3000d),
      new Vehiculo( "Logan","Renault", 950d)
    );

    Garaje garaje = new Garaje(1,vehiculos);

    System.out.println("Lista de los vehiculos ordenados por precio:");
    garaje.getVehiculos()
      .stream()
      .sorted(precio)
      .map(Vehiculo::toString)
      .forEach(System.out::println);


    System.out.println("Lista de los vehiculos ordenados por marca y precio:");
    garaje.getVehiculos()
      .stream()
      .sorted(marcaPrecio)
      .map(Vehiculo::toString)
      .forEach(System.out::println);

    System.out.println("Lista de los menores a $1000");
    garaje.getVehiculos()
      .stream()
      .sorted(precio)
      .filter(v -> v.getPrecio() <= 1000)
      .forEach(System.out::println);

    System.out.println("Lista de los mayores a $1000");
    garaje.getVehiculos()
      .stream()
      .sorted(precio)
      .filter(v -> v.getPrecio() > 1000)
      .forEach(System.out::println);

    Double promedio = garaje.getVehiculos()
      .stream()
      .mapToDouble(Vehiculo::getPrecio)
      .average()
      .orElseThrow(ArithmeticException::new);

    System.out.printf("El promedio de vehiculos es: $%s\n", Math.round(promedio));
  }
}