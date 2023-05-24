package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {


        double promedio = 0;
        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);

        Garage garage = new Garage(vehiculos);
        /**EJERCICIO3**/
        System.out.println("EJERCICIO 3");
        garage.getVehiculos().stream()
                                      .sorted(Comparator.comparing(Vehiculo::getCosto))
                                      .collect(Collectors.toList())
                                      .forEach(System.out::println);
        /**EJERCICIO4**/
        System.out.println("EJERCICIO 4");
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        /**EJERCICIO5**/
        System.out.println("EJERCICIO 5");

        List<Vehiculo> vehiculosMenorAMil = garage.getVehiculos().stream()
                .filter(c->c.getCosto() < 1000)
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("VEHICULOS CUYO COSTO ES MENOR A MIL");
        for(Vehiculo vehi : vehiculosMenorAMil){
            System.out.println(vehi.toString());
        }

        List<Vehiculo> vehiculosMedio = garage.getVehiculos().stream()
                .filter(c->c.getCosto() > 1000)
                .filter(c->c.getCosto() < 2000)
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("VEHICULOS CUYO COSTO SE ENCUENTRA ENTRE MIL y  DOS MIL ");
        for(Vehiculo vehi : vehiculosMedio){
            System.out.println(vehi.toString());
        }

        System.out.println("Promedio Total");

        promedio = garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0D);
        System.out.println("el promedio es: " + promedio);
        System.out.println("****Validando promedio*****");
        promedio = 0 ;
        for(Vehiculo v : garage.getVehiculos()){
            promedio += v.getCosto();
        }
        System.out.println("El promedio validado da: " + promedio/8);
    }
    
}
