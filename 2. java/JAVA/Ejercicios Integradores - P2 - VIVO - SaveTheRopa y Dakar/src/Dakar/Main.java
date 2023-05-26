package Dakar;


public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500, 5000, "GrandPrix", 5);

        carrera.darDeAltaAuto(200, 10, 10.0, 1234);
        carrera.darDeAltaMoto(150, 30, 50.0, 5678);
        carrera.darDeAltaMoto(150, 30, 50.0, 5679);

        Vehiculo vehiculoAEliminar = carrera.getListaDeVehiculos().get(1);

        carrera.eliminarVehiculo(vehiculoAEliminar);

    }
}