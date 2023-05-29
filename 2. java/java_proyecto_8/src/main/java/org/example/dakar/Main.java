package org.example.dakar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto(10, 10, 10, "10");
        Auto auto2 = new Auto(100, 100, 100, "100");
        List<Vehiculo> listaVehiculos= new ArrayList<>();
        listaVehiculos.add(auto);
        listaVehiculos.add(auto2);

        Carrera carrera = new Carrera(10, 10, "Carrera 1", 10, listaVehiculos);

        carrera.eliminarVehiculoConPatente("110");
        System.out.println("Ganador: " + carrera.calcularGanador());

        carrera.socorrerAuto("10");
    }
}