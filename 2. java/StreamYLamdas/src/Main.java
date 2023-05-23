import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

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

        Garage GarageCorrientes = new Garage(120, vehiculosList);

        //Ejercicio3: Imprimir ordenando por Precio de menor a mayor

        GarageCorrientes.getVehiculos()
                .stream()
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(vehiculo -> System.out.println(vehiculo));

    }
}