import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        //crea las listas de vehiculos
        List<Vehiculo> listaDeVehiculos = new ArrayList<Vehiculo>();

        listaDeVehiculos.add(new Auto(100.0, 10.0, 10, "ABC123"));
        listaDeVehiculos.add(new Auto(200.0, 10.0, 10, "ABC456"));
        listaDeVehiculos.add(new Moto(50.0, 10.0, 10, "ABC789"));
        listaDeVehiculos.add(new Moto(80.0, 10.0, 10, "ABC012"));

        //crea la carrera
        Carrera carrera = new Carrera(1000.0, 10000.0, "Nascar", 3,listaDeVehiculos);

        Auto auto = new Auto(100.0, 10.0, 10, "GTJ123");
        Moto moto = new Moto(120.0, 10.0, 10, "GTJ456");

        carrera.imprimirVehiculos();

        //Da de alta vehiculos a la carrera
        carrera.darDeAltaAuto(auto);
        carrera.darDeAltaMoto(moto);

        carrera.imprimirVehiculos();

        //elimina un vehiculo de la carrera
        carrera.eliminarVehiculo(auto);
        carrera.imprimirVehiculos();

        //socorre vehiculos
        carrera.darDeAltaAuto(auto);
        carrera.socorrerAuto(auto);
        carrera.socorrerMoto(moto);

        //muestra el ganador de la carrrera
        System.out.println("\nEl ganador de la carrera es el vehículo con patente: "+carrera.obtenerGanador().getPatente());

    }

}