import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creacion de la estructura
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Creacion de las variables.
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

        // Cargamos la Estructura
        vehiculos.addAll(
                Arrays.asList(
                        vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6,
                        vehiculo7, vehiculo8, vehiculo9, vehiculo10, vehiculo11
                )
        );

        // Ejercicio 3
        /*
        Haciendo uso del método sort en la lista de Vehículos con expresiones lambda,
        obtén una lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.
         */

        Comparator<Vehiculo> comparadorVehiculo = Comparator.comparing(Vehiculo::getCosto);

        vehiculos.stream()
                .sorted(comparadorVehiculo.reversed())
                //.map(vehiculo -> vehiculo.getMarca() + " " + vehiculo.getModelo() + ": $" + vehiculo.getCosto())
                .toList()
                .forEach(v -> System.out.println(v.toString()));

        System.out.println("----");
        System.out.println("Ejercicio 4");
        System.out.println("----");
        // Ejercicio 4
        /*
        De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
         */
        Comparator<Vehiculo> comparatorMarcaPrecio = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        vehiculos.stream()
                .sorted(comparatorMarcaPrecio)
                .toList()
                .forEach( v -> System.out.println(v.toString()));

        // Ejercicio 5
        /*
        Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000
        y por último, obtén el promedio total de precios de toda la lista de vehículos.
         */

        System.out.println("----");
        System.out.println("Ejercicio 5");
        System.out.println("----");
        System.out.println("Vehiculos con Precio no mayor a 1000");
        vehiculos.stream()
                .filter( v -> v.getCosto() < 1000)
                .toList()
                .forEach( v-> System.out.println(v.toString()));

        System.out.println("----");
        System.out.println("Vehiculos con Precio mayor o igual a 1000");
        vehiculos.stream()
                .filter( v -> v.getCosto() >= 1000)
                .toList()
                .forEach( v-> System.out.println(v.toString()));

        System.out.println("----");
        double porcentaje = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0D);
        System.out.println("El promedio total de precios es de : $" + porcentaje);
    }
}