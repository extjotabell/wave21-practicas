import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //Generamos una lista de vehiculos y completamos con los datos
        List<Vehiculo> vehiculosList = new ArrayList<>();

        vehiculosList.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculosList.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculosList.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculosList.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculosList.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculosList.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculosList.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculosList.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculosList.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculosList.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculosList.add(new Vehiculo("Renault", "Logan", 950));


        // Creamos el objeto Garage y le pasamos la lista de los vehiculos
        Garage GarageCorrientes = new Garage(120, vehiculosList);


        //Ejercicio3: Imprimir ordenamos por Precio de menor a mayor
        System.out.println("Ejercicio3: Imprimir ordenando por costo de menor a mayor");
        System.out.println("---------------------------------------------------------");
        GarageCorrientes.getVehiculos()
                .stream()
                .sorted((x, y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(vehiculo -> System.out.println(vehiculo));
        System.out.println("---------------------------------------------------------"+"\n");

        //Ejercicio4: Imprimir ordenando por marca y luego el costo de menor a mayor
        System.out.println("Ejercicio4: Imprimir ordenando por marca y luego el costo de menor a mayor");
        System.out.println("--------------------------------------------------------------------------");
        GarageCorrientes.getVehiculos()
                .stream()
                .sorted((x, y) -> x.getMarca().compareTo(y.getMarca()))
                .sorted((i, j) -> i.getCosto().compareTo(j.getCosto()))
                .forEach(vehiculo -> System.out.println(vehiculo));
        System.out.println("--------------------------------------------------------------------------"+"\n");


        //Ejercicio 5: Extraer los autos con precio menor a 1000 y luego sacar un promedio de los mismos
        System.out.println("Extraer los autos con precio menor a 1000 y luego sacar un promedio de los mismos");
        System.out.println("---------------------------------------------------------------------------------");
        OptionalDouble promedio =
        GarageCorrientes.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() <=1000)
                .mapToInt(Vehiculo::getCosto).average();
        System.out.println("El Valor promedio de los vehiculos con costo menor a 1000 es: " + promedio);
        System.out.println("--------------------------------------------------------------------------------"+"\n");


        }
    }
