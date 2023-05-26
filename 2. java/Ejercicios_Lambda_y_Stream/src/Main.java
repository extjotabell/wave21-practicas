import clases.Garage;
import clases.Vehiculo;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Garage garage;
        ArrayList<Vehiculo> carList = new ArrayList<>();

        carList.add(new Vehiculo("Ford", "Fiesta", 1000));
        carList.add(new Vehiculo("Ford", "Focus", 1200));
        carList.add(new Vehiculo("Ford", "Explorer", 2500));
        carList.add(new Vehiculo("Fiat", "Uno", 500));
        carList.add(new Vehiculo("Fiat", "Cronos", 1000));
        carList.add(new Vehiculo("Fiat", "Torino", 1250));
        carList.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        carList.add(new Vehiculo("Chevrolet", "Spin", 2500));
        carList.add(new Vehiculo("Toyota", "Corola", 1200));
        carList.add(new Vehiculo("Toyota", "Fortuner", 3000));
        carList.add(new Vehiculo("Renault", "Logan", 950));

        garage = new Garage(1, carList);

        System.out.println("Ejercicio 3: \n");
        for (Vehiculo v : garage.listOrdenada()){
            System.out.println(v.toString());
        }
        System.out.println("Ejercicio 4: \n");
        for (Vehiculo v : garage.listOrdenada()){
            System.out.println(v.toString());
        }
        System.out.println("Ejercicio 5: \n");
        System.out.println("Vehiculos con costo menor a $1000: \n");
        for (Vehiculo v : garage.listMenoresCostos()){
            System.out.println(v.toString());
        }
        System.out.println("\nVehiculos con costo mayor o igual a $1000: \n");
        for (Vehiculo v : garage.listMayoresCostos()){
            System.out.println(v.toString());
        }
        System.out.println("\nEl Promedio total de costos de los vehiculos es: \n" + "$" + Math.floor(garage.promedioCostos()) );

    }
}