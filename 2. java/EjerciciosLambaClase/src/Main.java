import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);

        // Crear instancias de los Vehiculo
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

        // Agregar los Vehiculos al garaje
        garaje.getVehiculo().add(vehiculo1);
        garaje.getVehiculo().add(vehiculo2);
        garaje.getVehiculo().add(vehiculo3);
        garaje.getVehiculo().add(vehiculo4);
        garaje.getVehiculo().add(vehiculo5);
        garaje.getVehiculo().add(vehiculo6);
        garaje.getVehiculo().add(vehiculo7);
        garaje.getVehiculo().add(vehiculo8);
        garaje.getVehiculo().add(vehiculo9);
        garaje.getVehiculo().add(vehiculo10);
        garaje.getVehiculo().add(vehiculo11);

        garaje.getVehiculo().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        for (Vehiculo vehiculo : garaje.getVehiculo()) {
            System.out.println(vehiculo.getModelo());
        }
        garaje.getVehiculo().sort(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto));
        for (Vehiculo vehiculo : garaje.getVehiculo()) {
            System.out.print(vehiculo.getMarca());
            System.out.println(" "+vehiculo.getCosto());
        }

        // Crear lista de vehculos con precios no mayores a 1000
        List<Vehiculo> vehiculosMenor1000 = new ArrayList<>();
        for (Vehiculo vehiculo : garaje.getVehiculo()) {
            if (vehiculo.getCosto() <= 1000) {
                vehiculosMenor1000.add(vehiculo);
            }
        }

        // Crear lista de Vehiculos con precios mayores o iguales a 1000
        List<Vehiculo> vehiculosMayor1000 = new ArrayList<>();
        for (Vehiculo vehiculo : garaje.getVehiculo()) {
            if (vehiculo.getCosto() >= 1000) {
                vehiculosMayor1000.add(vehiculo);
            }
        }

        // Calcular el promedio total de precios de toda la lista de Vehiculos
        double sumaPrecios = 0;
        for (Vehiculo vehiculo : garaje.getVehiculo()) {
            sumaPrecios += vehiculo.getCosto();
        }
        double promedioPrecios = sumaPrecios / garaje.getVehiculo().size();

        // Mostrar los Vehiculos con precios no mayores a 1000
        System.out.println("Vehiculos con precios no mayores a 1000:");
        for (Vehiculo vehiculo : vehiculosMenor1000) {
            System.out.print(vehiculo.getMarca());
            System.out.println(" "+vehiculo.getCosto());
        }

        // Mostrar los Vehiculos con precios mayores o iguales a 1000
        System.out.println("Vehiculos con precios mayores o iguales a 1000:");
        for (Vehiculo vehiculo : vehiculosMayor1000) {
            System.out.print(vehiculo.getMarca());
            System.out.println(" "+vehiculo.getCosto());
        }

        // Mostrar el promedio total de precios de toda la lista de Vehiculos
        System.out.println("Promedio total de precios de los Vehiculos: " + promedioPrecios);

    }
}