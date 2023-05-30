import Clases.Auto;
import Clases.Carrera;
import Clases.Moto;
import Clases.Vehiculo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Vehiculo moto1 = new Moto(100.0, 150.0, 30.5, "ABC150");
        Vehiculo moto2 = new Moto(101.9, 200.9, 20.1, "AAA111");
        Vehiculo moto3 = new Moto(80.9, 191.9, 20.3, "BBB222");
        Vehiculo auto1 = new Auto(200.2, 80.3, 50.1, "CCC123");
        Vehiculo auto2 = new Auto(259.1, 140.2, 19.1 , "TTT111");
        Vehiculo auto3 = new Auto(100.2, 149.2, 89.1 , "GGG111");

        Carrera dakar = new Carrera(200.9, 25300, "DAKAR",
                10);
        dakar.darDeAltaMoto(100.0, 150.0, 30.5, "ABC150");
        dakar.darDeAltaMoto(101.9, 200.9, 20.1, "AAA111");
        dakar.darDeAltaMoto(80.9, 191.9, 20.3, "BBB222");

        dakar.darDeAltaAuto(100.0, 150.0, 30.5, "ABC150");
        dakar.darDeAltaAuto(101.9, 200.9, 20.1, "AAA111");
        dakar.darDeAltaAuto(100.2, 149.2, 89.1 , "GGG111");




    }
}