import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);

        List<Vehiculo> vehiculos = new ArrayList<>(List.of(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6, vehiculo7));
        Garaje garaje = new Garaje(1, vehiculos);

        System.out.println("Vehiculos ordenados por costo");
        List<Vehiculo> vehiculosOrdenados = garaje.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).toList();
        System.out.println(vehiculosOrdenados);

        System.out.println("Vehiculos ordenados por marca, y luego precio");
        vehiculosOrdenados = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).toList();
        System.out.println(vehiculosOrdenados);

        System.out.println("Filtrado por costo menor o igual a 1000");
        List<Vehiculo> vehiculosFiltradosMenoresIgualesAMil = garaje.getVehiculos().stream().filter(v -> v.getCosto() <= 1000D).toList();
        System.out.println(vehiculosFiltradosMenoresIgualesAMil);

        System.out.println("Filtrado por costo mayor a 1000");
        List<Vehiculo> vehiculosFiltradosMayoresAMil = garaje.getVehiculos().stream().filter(v -> v.getCosto() > 1000D).toList();
        System.out.println(vehiculosFiltradosMayoresAMil);

        System.out.println("Calculo de promedio");
        double avg = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0D);
        System.out.println("El costo promedio es: " + avg);


    }
}
