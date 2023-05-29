import Clases.Carrera;
import Clases.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Carrera newCarrera = new Carrera(500, 1000000, "Indiana Grand Prix", 5);
        newCarrera.darDeAltaAuto(50,10,5,"AD123");
        newCarrera.darDeAltaMoto(20,15,20,"AA123");
        newCarrera.darDeAltaAuto(10,10,5,"AB123");
        newCarrera.darDeAltaMoto(100,150,20,"AE123");
        newCarrera.darDeAltaMoto(5,10,10,"AF123");

        Vehiculo ganador = newCarrera.calcularGanador();
        System.out.println("El Primer Ganador es: " + ganador.toString());

        System.out.println("--- Eliminando el Vehiculo Ganador con Patente: AE123 ---");
        newCarrera.eliminarVehiculoConPatente("AE123");

        newCarrera.socorrerAuto("AD123");
        newCarrera.socorrerAuto("AF123");
        newCarrera.socorrerMoto("AE123");
        newCarrera.socorrerMoto("AF123");

        ganador = newCarrera.calcularGanador();
        System.out.println("El Segundo ganador es: " + ganador.toString());
    }
}