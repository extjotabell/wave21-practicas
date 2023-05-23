import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

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

        List<Vehiculo> vehiculos = Arrays.asList(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11);

        Garaje garaje = new Garaje("1",vehiculos);

        List<Vehiculo> sortPrecio = garaje.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getPrecio)).collect(Collectors.toList());
        //List<Vehiculo> sortPrecio = garaje.getVehiculos().stream().sorted((v1, v2) -> Double.compare(v1.getPrecio(), v2.getPrecio())).collect(Collectors.toList());

        System.out.println(sortPrecio);

        List<Vehiculo> sortMarcaPrecio = garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getPrecio))
                .collect(Collectors.toList());

        System.out.println(sortMarcaPrecio);

        List<Vehiculo> menor1000 = garaje.getVehiculos()
                .stream()
                .filter(v -> v.getPrecio() < 1000)
                .collect(Collectors.toList());

        System.out.println(menor1000);

        List<Vehiculo> mayor1000 = garaje.getVehiculos()
                .stream()
                .filter(v -> v.getPrecio() >= 1000)
                .collect(Collectors.toList());

        System.out.println(mayor1000);

        double promedio = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average()
                .orElse(0);

        System.out.println(promedio);

    }
}