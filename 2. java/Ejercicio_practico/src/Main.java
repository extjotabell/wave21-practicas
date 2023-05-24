import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Logan", "FORTUNER", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        Vehiculo[] v = {v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11};

        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>(List.of(v));


        Garaje garaje = new Garaje("1", vehiculos);

        List<Vehiculo> ordenadosPorPrecio = garaje.getVehiculos().stream().sorted((a, b) -> Double.compare(a.getPrecio(), b.getPrecio())).collect(Collectors.toList());
        System.out.println(ordenadosPorPrecio);
        List<Vehiculo> ordenadosPorMarcaPrecio = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getPrecio)).collect(Collectors.toList());
        System.out.println(ordenadosPorMarcaPrecio);

        List<Vehiculo> menorA1000 = garaje.getVehiculos().stream().filter(n -> n.getPrecio()<1000).collect(Collectors.toList());
        List<Vehiculo> mayorA1000 = garaje.getVehiculos().stream().filter(n -> n.getPrecio()>=1000).collect(Collectors.toList());
        double promedioPrecio = garaje.getVehiculos().stream().mapToDouble(n->n.getPrecio()).average().orElse(0D);

        System.out.println(menorA1000);
        System.out.println(mayorA1000);
        System.out.println(promedioPrecio);

    }

}