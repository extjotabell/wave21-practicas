import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.addAll;

public class Main {
    public static void main(String[] args) {

        //suma = numbers.stream().
        //mapToInt(n --> n)
        //.sum();
        //.filter(n -->n.length < 5)
        //.collect(Collectors.toList());

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(vehiculo1);
        vehiculoList.add(vehiculo2);
        vehiculoList.add(vehiculo3);
        vehiculoList.add(vehiculo4);
        vehiculoList.add(vehiculo5);
        vehiculoList.add(vehiculo6);
        vehiculoList.add(vehiculo7);
        vehiculoList.add(vehiculo8);
        vehiculoList.add(vehiculo9);
        vehiculoList.add(vehiculo10);
        vehiculoList.add(vehiculo11);

        Garage garage = new Garage(1, vehiculoList);

        //ordenado por costo
        List<Vehiculo> listaOrdenada = new ArrayList<>();
        listaOrdenada = vehiculoList.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("Ordenado solo por costo: " + listaOrdenada);

        //ordenado por marca y costo
        List<Vehiculo> listaOrdenada2 = new ArrayList<>();
        listaOrdenada2 = vehiculoList.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("Ordenado por marca y costo: " + listaOrdenada2);


        //precio no mayor a 1000
        List<Vehiculo> listaMenorA1000 = new ArrayList<>();
        listaMenorA1000 = vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getCosto()<1000)
                .collect(Collectors.toList());
        System.out.println("Precio no mayor a 1000: " + listaMenorA1000);

        //precio mayor o igual a 1000
        List<Vehiculo> listaMayorOIgualA1000 = new ArrayList<>();
        listaMayorOIgualA1000 = vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        System.out.println("Precio mayor o igual a 1000: " + listaMayorOIgualA1000);

        //promedio total de precios
        double promedio =0;
        promedio = vehiculoList.stream().mapToDouble(Vehiculo::getCosto)
                        .average()
                                .orElse(0.0);

        System.out.println("Promedio: " + promedio);
    }
}