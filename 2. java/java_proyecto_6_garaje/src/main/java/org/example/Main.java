package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>() {{
            add(new Vehiculo("Ford", "Fiesta", 1000));
            add(new Vehiculo("Ford", "Focus", 1200));
            add(new Vehiculo("Ford", "Explorer", 2500));
            add(new Vehiculo("Fiat", "Uno", 500));
            add(new Vehiculo("Fiat", "Cronos", 1000));
            add(new Vehiculo("Fiat", "Torino", 1250));
            add(new Vehiculo("Chevrolet", "Aveo", 1250));
            add(new Vehiculo("Chevrolet", "Spin", 2500));
            add(new Vehiculo("Toyota", "Corola", 1200));
            add(new Vehiculo("Toyota", "Fortuner", 3000));
            add(new Vehiculo("Renault", "Logan", 950));
        }};


        Garaje garaje = new Garaje(1, vehiculos);

//        Metodo Clasico
//        List<Vehiculo> ordenadosPrecio = garaje.getVehiculoList().stream()
//                .sorted((v1, v2) -> (int) (v1.getCosto() - v2.getCosto()))
//                .toList();

//        Metodo con comparator
        List<Vehiculo> ordenadosPrecio = garaje.getVehiculoList().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .toList();

        List<Vehiculo> ordenadosPrecioInverso = garaje.getVehiculoList().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto).reversed())
                .toList();


        System.out.println(ordenadosPrecio);
        System.out.println(ordenadosPrecioInverso);

        List<Vehiculo> ordenadoMarcaYPrecio = garaje.getVehiculoList().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .sorted(Comparator.comparing((Vehiculo::getCosto)))
                .toList();

        System.out.println(ordenadoMarcaYPrecio);

        List<Vehiculo> noMayor1000 = garaje.getVehiculoList().stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .sorted(Comparator.comparing(Vehiculo::getCosto).reversed())
                .toList();

        System.out.println(noMayor1000);

        List<Vehiculo> mayor1000 = garaje.getVehiculoList().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000 )
                .sorted(Comparator.comparing(Vehiculo::getCosto).reversed())
                .toList();

        System.out.println(mayor1000);

        double promedio = garaje.getVehiculoList().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println(promedio);
    }
}