package org.example;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 2
        Garage garage = new Garage(1);
        garage.addVehicle(new Vehicle("Fiesta", "Ford", 1000));
        garage.addVehicle(new Vehicle("Focus", "Ford", 1200));
        // Continuar añadiendo los vehículos...

        // Ejercicio 3
        List<Vehicle> sortedByPrice = garage.getVehicles().stream()
                .sorted(Comparator.comparingInt(Vehicle::getCost))
                .collect(Collectors.toList());
        sortedByPrice.forEach(v -> System.out.println(v.getModel() + " " + v.getBrand() + ": " + v.getCost()));

        // Ejercicio 4
        List<Vehicle> sortedByBrandAndPrice = garage.getVehicles().stream()
                .sorted(Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getCost))
                .collect(Collectors.toList());
        sortedByBrandAndPrice.forEach(v -> System.out.println(v.getBrand() + " " + v.getModel() + ": " + v.getCost()));

        // Ejercicio 5
        List<Vehicle> cheaperVehicles = garage.getVehicles().stream()
                .filter(v -> v.getCost() < 1000)
                .collect(Collectors.toList());

        List<Vehicle> expensiveVehicles = garage.getVehicles().stream()
                .filter(v -> v.getCost() >= 1000)
                .collect(Collectors.toList());

        double averageCost = garage.getVehicles().stream()
                .mapToInt(Vehicle::getCost)
                .average()
                .orElse(0);

        System.out.println("Average cost: " + averageCost);
    }
}