package Dakar;


public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500, 5000, "GrandPrix", 5);

        carrera.darDeAltaAuto(200, 10, 10.0, 1234);
        carrera.darDeAltaMoto(150, 30, 50.0, 5678);
        carrera.darDeAltaMoto(140, 25, 50.0, 9101);
        carrera.darDeAltaAuto(250, 10, 12.0, 5674);

        Vehiculo vehiculoAEliminar = carrera.getListaDeVehiculos().get(1);

        carrera.eliminarVehiculo(vehiculoAEliminar);
        carrera.eliminarVehiculoConPatente("5674");

        carrera.ganador();

        carrera.socorrerAuto("1234");
        carrera.socorrerMoto("5678");
    }
}