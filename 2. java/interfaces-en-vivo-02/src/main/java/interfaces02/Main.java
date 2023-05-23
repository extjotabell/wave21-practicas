package interfaces02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    //Ejercicio 2
    public static void main(String[] args) {
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

        List<Vehiculo> vehiculos = new ArrayList<>();
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

        Garaje garaje = new Garaje(1, 1 , vehiculos);

        //Ejercicio 3
        System.out.println("EJERCICIO 3 ---------");
        List<Vehiculo> listaFiltradaCosto = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).toList();
        listaFiltradaCosto.forEach(item -> {
            System.out.println(item.toString());
        });

        //Ejercicio 4
        System.out.println("EJERCICIO 4 ---------");
        List<Vehiculo> listaFiltradaMarcaCosto = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto)).toList();
        listaFiltradaMarcaCosto.forEach(item -> {
            System.out.println(item.toString());
        });

        //Ejercicio 5
        List<Vehiculo> listaFiltradaMenoresAMil = vehiculos.stream().filter(item -> item.getCosto() <= 1000).toList();
        System.out.println("EJERCICIO 5 ---------  PARTE 1 MENORES DE MIL");
        listaFiltradaMenoresAMil.forEach(item -> {
            System.out.println(item.toString());
        });


        List<Vehiculo> listaFiltradaMayoresAMil = vehiculos.stream().filter(item -> item.getCosto() >= 1000).toList();
        System.out.println("EJERCICIO 5 ---------  PARTE 2 MAYORES DE MIL");
        listaFiltradaMayoresAMil.forEach(item -> {
            System.out.println(item.toString());
        });

        double promedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0D);
        System.out.println("EJERCICIO 5 ---------  PARTE 3 PROMEDIO");
        System.out.println("El promedio es: " + Math.round(promedio));
    }
}
