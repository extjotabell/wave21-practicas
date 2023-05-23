import clases.Garaje;
import clases.Vehiculo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000d);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200d);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500d);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500d);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000d);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250d);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250d);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500d);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200d);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000d);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950d);

        Garaje garaje= new Garaje("1", Arrays.asList(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11));

        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList())
                .forEach(v->System.out.println(v.toString()));
        System.out.println("------------------------------------------------");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList())
                .forEach(v->System.out.println(v.toString()));
        System.out.println("------------------------------------------------");
        System.out.println("Lista menor a 1000");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList())
                .forEach(vehiculo -> System.out.println(vehiculo.toString()));
        System.out.println("\nLista mayor e igual a 1000");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList())
                .forEach(vehiculo -> System.out.println(vehiculo.toString()));

        Double average = garaje.getVehiculos().stream().collect(Collectors.averagingDouble(Vehiculo::getCosto));

        System.out.println("\nEl promedio es: "+average );
    }
}