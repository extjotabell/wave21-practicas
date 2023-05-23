import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
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

        System.out.println("Precio");
        garage.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("Marca y precio");
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparingDouble(Vehiculo::getCosto)).forEach(System.out::println);


        System.out.println("Menores a 1000");
        garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);

        System.out.println("Mayores o igual a 1000");
        garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);

        System.out.println("Promedio:" + garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0));
    }
}