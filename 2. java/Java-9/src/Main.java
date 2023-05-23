import clases.Garage;
import clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1, vehiculos);

        garage.getVehiculos()
                .stream()
                .map(Vehiculo::getPrecio)
                .sorted()
                .forEach(System.out::println);

        garage.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio))
                .forEach(System.out::println);


        List<Vehiculo> vehiculosMenor = garage.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getPrecio() < 1000)
                .collect(Collectors.toList());

        System.out.println(vehiculosMenor);

        List<Vehiculo> vehiculosMayor = garage.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getPrecio() >= 1000)
                .collect(Collectors.toList());

        System.out.println(vehiculosMayor);

        OptionalDouble avg = garage.getVehiculos()
                .stream()
                .mapToInt(Vehiculo::getPrecio)
                .average();

        if(avg.isPresent()) System.out.println(avg.getAsDouble());
    }
}