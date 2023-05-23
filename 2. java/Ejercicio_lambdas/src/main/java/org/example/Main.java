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
      new Vehiculo("Renault", "Logan", 950d)
    );

    Garaje garaje = new Garaje(1,vehiculos);

    System.out.println("VEHÍCULOS ORDENADOS POR PRECIO\n");
    garaje.getVehiculos()
      .stream()
      .sorted(precio)
      .map(Vehiculo::toString)
      .forEach(System.out::println);

    System.out.println("\nVEHÍCULOS ORDENADOS POR MARCA Y PRECIO\n");
    garaje.getVehiculos()
      .stream()
      .sorted(marcaPrecio)
      .map(Vehiculo::toString)
      .forEach(System.out::println);

    System.out.println("\nVEHÍCULOS CON PRECIO MENOR A 1000\n");
    garaje.getVehiculos()
            .stream()
            .filter(p->p.getPrecio()<1000)
            .forEach(System.out::println);

    System.out.println("\nVEHÍCULOS CON PRECIO MAYOR O IGUAL A 1000\n");
    garaje.getVehiculos()
            .stream()
            .filter(p->p.getPrecio()>=1000)
            .forEach(System.out::println);

    System.out.println("\nPROMEDIO DE LA LISTA VEHICULOS");
    Double average = garaje.getVehiculos()
            .stream()
            .mapToDouble(Vehiculo::getPrecio)
            .average()
            .orElse(0D);
    average=Math.round(average * 1000.0)/1000.0;

    System.out.println(average);
  }
}