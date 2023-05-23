import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1000);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);

        Garage garage = new Garage("01", vehiculos);

        // Lista ordenada según costo del vehiculo
        List<Vehiculo> vehiculosOrdenadoPrecio = vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).toList();
        System.out.println(vehiculosOrdenadoPrecio);

        // Ordenar la lista de vehículos por marca y luego por precio
        List<Vehiculo> vehiculosOrdenadoMarcaPrecio = vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).toList();
        System.out.println(vehiculosOrdenadoMarcaPrecio);

        // Obtener vehiculos cuyo costo sea menor a 1000
        List<Vehiculo> vehiculosBaratos = vehiculos.stream().filter(n -> n.getCosto() < 1000).toList();
        System.out.println(vehiculosBaratos);

        // Obtener vehiculos cuyo costo sea mayor o igual a 1000
        List<Vehiculo> vehiculosMedio = vehiculos.stream().filter(n -> n.getCosto() >= 1000).toList();
        System.out.println(vehiculosMedio);

        // Promedio de todos los vehiculos en la lista
        double vehiculosPromedio = vehiculos.stream().mapToDouble(n -> n.getCosto()).average().orElse(0D);
        System.out.println(vehiculosPromedio);
        }
    }
