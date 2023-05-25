package Ejercicio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corolla", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);
        vehiculos.add(v7);
        vehiculos.add(v8);
        vehiculos.add(v9);
        vehiculos.add(v10);
        vehiculos.add(v11);

        Garage garage = new Garage(1,vehiculos);

        /*Parte 3*/
        /*Lambda*/
        vehiculos.sort((Vehiculo va, Vehiculo vb) -> va.getCosto() - (vb.getCosto()));
        vehiculos.stream().forEach((System.out::println));

        /*Stream*/
        garage.getVehiculos().stream().sorted(Comparator.comparingInt(Vehiculo::getCosto)).forEach(System.out::println);

        /*Parte 4*/

        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        /*Parte 5 - Vehículos con precio no mayor a 1000*/
        System.out.println("Vehiculos menos a 1000");
        garage.getVehiculos().stream().filter(x -> x.getCosto() < 1000).forEach(System.out::println);

        /*Parte 5 - Vehículos con precio mayor o igual a 1000*/
        System.out.println("Vehiculos Mayor o igual a 1000");
        garage.getVehiculos().stream().filter(x -> x.getCosto() >= 1000).forEach(System.out::println);

        /*Parte 5 - Promedio de precios*/
        System.out.println("Vehiculos promedio");
        System.out.println((garage.getVehiculos().stream().mapToInt(x -> x.getCosto()).average()).toString());
    }
}