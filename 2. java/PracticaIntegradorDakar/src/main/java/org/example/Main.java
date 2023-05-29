package org.example;

public class Main {
    public static void main(String[] args) {

        Carrera granPrixRadiadorS = new Carrera(174.5, 3000.0, "Gran Prix de Radiador Springs", 10);

        System.out.println("  ******************** Autos  ******************** ");
        granPrixRadiadorS.darAltaAuto(200.0, 110.0, 75.0, "RLR424"); // calculo = 0.2444
        granPrixRadiadorS.darAltaAuto(300.0, 100.0, 75.0, "RRR567"); // calculo = 0.3333
        granPrixRadiadorS.darAltaAuto(270.0, 84.0, 90.0, "JKI098"); // calculo = 0.21
        granPrixRadiadorS.darAltaAuto(270.0, 84.0, 90.0, "ABC123"); // calculo = 0.21

        //Eliminar un auto
        System.out.println("  ******************** Eliminar Autos  ******************** ");
        granPrixRadiadorS.eliminarVehiculo("ABC123");

        System.out.println(" ******************** Motos  ******************** ");
        granPrixRadiadorS.darAltaMoto(150.0, 59.7, 34.2, "ONE23F"); // calculo = 1.309
        granPrixRadiadorS.darAltaMoto(350.0, 7.3, 150.0, "ENW12G"); // calculo = 0.0851
        granPrixRadiadorS.darAltaMoto(233.0, 75.3, 150.0, "PYQ77J"); // calculo = 0.58483

        //Eliminar un moto
        System.out.println("  ******************** Eliminar Motos  ******************** ");
        granPrixRadiadorS.eliminarVehiculo("EN12G");

        //Socorrer Vehiculos
        System.out.println(" ******************** Socorrer Vehiculos de la carrera ******************** ");
        granPrixRadiadorS.socorrerAuto("RLR424");
        granPrixRadiadorS.socorrerAuto("ABC123"); //Se elimino el vehiculo
        granPrixRadiadorS.socorrerMoto("ENW12G");
        granPrixRadiadorS.socorrerMoto("PYQ77J");

        //Ganador
        System.out.println(" ******************** Ganador de la carrera ******************** ");
        granPrixRadiadorS.imprimirGanador();

    }
}