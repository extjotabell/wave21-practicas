package EjerciciosLambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);

        Garage garage1 = new Garage(1, vehiculos);

        /*
        //ej3: Listado ordenado de vehiculos en base a costo
        vehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto)).toList()
                .forEach(System.out::println);


        //ej4: Listado ordenado de vehiculos en base a marca y costo
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).toList()
                .forEach(System.out::println);

        //ej5: Listado de vehiculos de precio no mayor a 5000
        vehiculos.stream()
                .filter(x-> x.getCosto() <= 5000)
                .forEach(System.out::println);

        //Listado de vehiculos de precio mayor o igual a 1000
        vehiculos.stream()
                .filter(x-> x.getCosto() >= 1000)
                .forEach(System.out::println);  */

        //Promedio total de precios de toda la lista
        double promedioPrecios = vehiculos.stream()
                .mapToDouble(x -> x.getCosto()).average().orElse(00);
        System.out.println(promedioPrecios);

    }
}
