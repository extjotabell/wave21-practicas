package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(21,10000,"F1", 3);
        carrera.darDeAltaAuto(130, 13,45,"AA11AA");
        carrera.darDeAltaMoto(150, 20,45,"BB22BB");
        carrera.darDeAltaAuto(130, 13,45,"AA22DD");
        carrera.darDeAltaMoto(150, 20,45,"CC22CC");

        carrera.getGanador();
        carrera.eliminarVehiculoConPatente("AA11AA");
        carrera.socorrerAuto("AA22DD");
        carrera.socorrerMoto("BB22BB");
    }
}