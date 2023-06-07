import clases.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.print("Bienvenido al dakar!");

        Auto auto1 = new Auto(80, 5, 50, "CBSA-23");
        Auto auto2 = new Auto(120, 5, 45, "ABCD-12");
        Auto auto3 = new Auto(90, 4, 40, "DEFG-45");
        Auto auto4 = new Auto(100, 4, 30, "JKAL-45");
        Auto auto5 = new Auto(95, 3, 50, "LASD-34");
        List<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(auto1, auto2, auto3, auto4, auto5));

        SocorristaMoto motoSocorrista = new SocorristaMoto(100, 4, 50, "SOCM-21");
        SocorristaAuto autoSocorrista = new SocorristaAuto(100, 4, 50, "SOCA-21");

        Carrera dakar = new Carrera(1000, 10000, "Dakar", 6, vehiculos, autoSocorrista, motoSocorrista);

        System.out.println("\n" + dakar.getVehiculos());
        dakar.eliminarVehiculo(auto1);

        System.out.println("\n" + dakar.getVehiculos());
        dakar.darDeAltaAuto(85, 4, 65, "ASDF-21");

        System.out.println("\n" + dakar.getVehiculos());
        dakar.eliminarVehiculoConPatente("ASDF-21");

        System.out.println("\n" + dakar.getVehiculos());
        dakar.socorrerAuto("DEFG-45");

        System.out.println("\n" + dakar.defineGanador());
    }
}