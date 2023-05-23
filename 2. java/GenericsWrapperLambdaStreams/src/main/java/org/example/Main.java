package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        //Ejercicio 2
        Vehiculo vehiculo1 = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus","Ford",1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer","Ford",2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno","Fiat",500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos","Fiat",1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino","Fiat",1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo","Chevrolet",1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin","Chevrolet",2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola","Toyota",1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner","Toyota",3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan","Renault",950);

        List<Vehiculo> listVehiculos = new ArrayList<>();
        listVehiculos.add(vehiculo1);
        listVehiculos.add(vehiculo2);
        listVehiculos.add(vehiculo3);
        listVehiculos.add(vehiculo4);
        listVehiculos.add(vehiculo5);
        listVehiculos.add(vehiculo6);
        listVehiculos.add(vehiculo7);
        listVehiculos.add(vehiculo8);
        listVehiculos.add(vehiculo9);
        listVehiculos.add(vehiculo10);
        listVehiculos.add(vehiculo11);

        Garaje garaje = new Garaje(1,1, listVehiculos);

        //Ejercicio 3
        List<Vehiculo> listaFiltradaCosto = listVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getPrecio)).toList();
        System.out.println("*************** Ejercicio 3 *****************");
        listaFiltradaCosto.forEach(item ->{
            System.out.println(item.toString());
        });

        //Ejercicio 4
        List<Vehiculo> listaFiltradaMarcaCosto = listVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio)).toList();
        System.out.println("*************** Ejercicio 4 *****************");
        listaFiltradaCosto.forEach(item ->{
            System.out.println(item.toString());
        });

        //Ejercicio 5
        List<Vehiculo> listaFiltradaMenoresAMil = listVehiculos.stream().filter(item -> item.getPrecio() <= 1000).toList();
        System.out.println("*************** Ejercicio 5 Parte 1 - Menores de Mil *****************");
        listaFiltradaMenoresAMil.forEach(item ->{
            System.out.println(item.toString());
        });

        List<Vehiculo> listaFiltradaMayoresAMil = listVehiculos.stream().filter(item -> item.getPrecio() >= 1000).toList();
        System.out.println("*************** Ejercicio 5 Parte 2 - Mayores de Mil *****************");
        listaFiltradaMayoresAMil.forEach(item ->{
            System.out.println(item.toString());
        });

        double promedio = listVehiculos.stream().mapToDouble(Vehiculo::getPrecio).average().orElse(0D);
        System.out.println("*************** Ejercicio 5 Parte 3 - Promedio *****************");
        System.out.println("El promedio es: "+promedio);




    }


}