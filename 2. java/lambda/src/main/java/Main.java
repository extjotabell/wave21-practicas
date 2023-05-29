import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        Vehiculo auto1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo auto2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo auto3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo auto4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo auto5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo auto6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo auto7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo auto8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo auto9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo auto10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo auto11 = new Vehiculo("Logan", "Renault", 950);

        listaVehiculos.add(auto1);
        listaVehiculos.add(auto2);
        listaVehiculos.add(auto3);
        listaVehiculos.add(auto4);
        listaVehiculos.add(auto5);
        listaVehiculos.add(auto6);
        listaVehiculos.add(auto7);
        listaVehiculos.add(auto8);
        listaVehiculos.add(auto9);
        listaVehiculos.add(auto10);
        listaVehiculos.add(auto11);
        Garaje garaje = new Garaje(1, listaVehiculos);

        /*
        for (Vehiculo vehiculo: listaVehiculos){
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo());
        }
        */

        // Ejercicio 3:
        //listaVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto).thenComparing(Vehiculo::getCosto)).forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " con un total de: " + vehiculo.getCosto())); //Sorting by person id and then by age.

        // Ejercicio 4:
        //listaVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " con un total de: " + vehiculo.getCosto())); //Sorting by person id and then by age.


        // Ejercicio 5
        System.out.println(listaVehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).mapToInt(Vehiculo::getCosto).average().orElse(0));

    }
}
