package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> carList = new ArrayList<>();

        carList.add(new Vehiculo("Ford", "Fiesta", 1000));
        carList.add(new Vehiculo("Ford", "Focus", 1200));
        carList.add(new Vehiculo("Ford", "Explorer", 2500));
        carList.add(new Vehiculo("Fiat", "Uno", 500));
        carList.add(new Vehiculo("Fiat", "Cronos", 1000));
        carList.add(new Vehiculo("Fiat", "Torino", 1250));
        carList.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        carList.add(new Vehiculo("Chevrolet", "Spin", 2500));
        carList.add(new Vehiculo("Toyota", "Corola", 1200));
        carList.add(new Vehiculo("Toyota", "Fortuner", 3000));
        carList.add(new Vehiculo("Renault", "Logan", 950));

        //Agregamos 2 Aveo mas para testear el sorted de marca + Costo
        carList.add(new Vehiculo("Chevrolet", "Aveo", 1200));
        carList.add(new Vehiculo("Chevrolet", "Aveo", 400));

        Garage garage = new Garage(1, carList);

        System.out.println("-------Ejercicio 3-------");
        List<Vehiculo> costList = garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        for (Vehiculo v: costList){
            System.out.println(v.toString());
        }

        System.out.println("-------Ejercicio 4-------");
        List<Vehiculo> list2 = garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        for (Vehiculo v: list2){
            System.out.println(v.toString());
        }


        System.out.println("-------Ejercicio 5-------");
        System.out.println("Menores a 1000");
        List<Vehiculo> listaMenorPrecio = garage.getVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .collect(Collectors.toList());

        for (Vehiculo v: listaMenorPrecio){
            System.out.println(v.toString());
        }
        System.out.println("Mayor e igual a 1000");
        List<Vehiculo> listaMayorPrecio = garage.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .collect(Collectors.toList());

        for (Vehiculo v: listaMayorPrecio){
            System.out.println(v.toString());
        }
        System.out.println("Promedio de Costos");
        double promedio = garage.getVehiculos().stream()
                .mapToDouble(n -> n.getCosto())
                .average()
                .orElse(0D);
        System.out.println("El promedio total de costos es "+ Math.floor(promedio)+ "$");

    }
}