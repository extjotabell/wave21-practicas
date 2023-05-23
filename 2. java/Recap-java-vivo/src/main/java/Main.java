import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        Garaje garaje = new Garaje(1);
        garaje.getVehiculos().add(vehiculo1);
        garaje.getVehiculos().add(vehiculo2);
        garaje.getVehiculos().add(vehiculo3);
        garaje.getVehiculos().add(vehiculo4);
        garaje.getVehiculos().add(vehiculo5);
        garaje.getVehiculos().add(vehiculo6);
        garaje.getVehiculos().add(vehiculo7);
        garaje.getVehiculos().add(vehiculo8);
        garaje.getVehiculos().add(vehiculo9);
        garaje.getVehiculos().add(vehiculo10);
        garaje.getVehiculos().add(vehiculo11);

        garaje.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));

                   // Ejercicio 1, 2 y 3 //
        // Imprimir la lista ordenada de vehículos
       /* List<Vehiculo> vehiculosOrdenados = garaje.getVehiculos();
        for (Vehiculo vehiculo : vehiculosOrdenados) {
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Precio: " + vehiculo.getCosto());
            System.out.println();
        }*/
                    // FIN Ejercicio 1, 2 y 3 //

                       // Ejercicio 4 //
        // Ordenar la lista de vehículos por marca y a su vez por precio
        garaje.getVehiculos().sort(
                Comparator.comparing(Vehiculo::getMarca)
                        .thenComparingDouble(Vehiculo::getCosto)
        );

        // Imprimir la lista ordenada de vehículos
        List<Vehiculo> vehiculosOrdenados = garaje.getVehiculos();
        for (Vehiculo vehiculo : vehiculosOrdenados) {
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Precio: " + vehiculo.getCosto());
            System.out.println();
        }
                   // FIN Ejercicio 4 //
    }
}
