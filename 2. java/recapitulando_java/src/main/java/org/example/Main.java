package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Chevrolet", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Toyota", "Logan", 950);

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        List<Vehiculo> vehiculosOrdenadorPrecio = vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio))
                .collect(Collectors.toList());

        System.out.println("");
        System.out.println("Ordenados por Precio");
        System.out.println("");

        for (Vehiculo vehiculo : vehiculosOrdenadorPrecio) {
            System.out.println(vehiculo);
        }

        Comparator<Vehiculo> ordenMarcaPrecio = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio);

        List<Vehiculo> vehiculosOrdenadosMarcaPrecio = vehiculos.stream()
                .sorted(ordenMarcaPrecio)
                .collect(Collectors.toList());

        System.out.println("");
        System.out.println("Ordenados por Marca y Precio");
        System.out.println("");

        for (Vehiculo vehiculo : vehiculosOrdenadosMarcaPrecio) {
            System.out.println(vehiculo);
        }

        System.out.println("");
        System.out.println("Vehiculos < 1000");
        System.out.println("");

        List<Vehiculo> vehiculosMenor1000 = vehiculos.stream()
                .filter(n -> n.getPrecio() < 1000)
                .collect(Collectors.toList());

        for (Vehiculo vehiculo : vehiculosMenor1000) {
            System.out.println(vehiculo);
        }

        System.out.println("");
        System.out.println("Vehiculos >= 1000");
        System.out.println("");

        List<Vehiculo> vehiculosMayor1000 = vehiculos.stream()
                .filter(n -> n.getPrecio() >= 1000)
                .collect(Collectors.toList());

        for (Vehiculo vehiculo : vehiculosMayor1000) {
            System.out.println(vehiculo);
        }

        System.out.println("");
        System.out.println("Promedio");
        System.out.println("");

        double sumaPrecio = vehiculos.stream()
                .mapToDouble(n -> n.getPrecio())
                .sum();

        double promedio = sumaPrecio / vehiculos.size();

        System.out.println(promedio);

    }
}