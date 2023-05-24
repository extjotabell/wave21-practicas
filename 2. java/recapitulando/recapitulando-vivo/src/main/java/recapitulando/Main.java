package recapitulando;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garage garage = new Garage(1, vehiculos);

        System.out.println("----------------------------------------------------");
        System.out.println("Comparar por precio");
        System.out.println("----------------------------------------------------");
        garage.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        for (Vehiculo vehiculo: garage.getVehiculos()) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Comparar por marca y precio");
        System.out.println("----------------------------------------------------");

        garage.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto));
        for (Vehiculo vehiculo: garage.getVehiculos()) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Costo mayor a 1000");
        System.out.println("----------------------------------------------------");
        garage.getVehiculos().stream().filter(x  -> x.getCosto() > 1000).forEach(System.out::println);

        System.out.println("----------------------------------------------------");
        System.out.println("Costo mayor igual a 1000");
        System.out.println("----------------------------------------------------");
        garage.getVehiculos().stream().filter(x  -> x.getCosto() >= 1000).forEach(System.out::println);

        System.out.println("----------------------------------------------------");
        System.out.println("Promedio");
        System.out.println("----------------------------------------------------");
        System.out.println(garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average());
    }
}
