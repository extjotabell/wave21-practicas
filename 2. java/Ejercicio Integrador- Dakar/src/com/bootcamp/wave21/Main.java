package com.bootcamp.wave21;

public class Main {

    public static void main(String[] args) {
	Carrera dakar = new Carrera(5235, 4532, "Dakar", 6);
    dakar.darDeAltaMoto(52, 3, 5, "PPP123");
    dakar.darDeAltaMoto(22, 3, 5, "PTT123");
    dakar.darDeAltaMoto(22, 3, 5, "MMM123");
    dakar.darDeAltaAuto(32,3,4,"JJJ123");
    dakar.darDeAltaMoto(15,3,2,"HHH!23");
    dakar.darDeAltaAuto(32,3,2,"III123");
    dakar.darDeAltaMoto(113,3,14,"KKK123");
    dakar.socorrerMoto("PPP123");
    dakar.socorrerAuto("JJJ123");
    Vehiculo ganador  = dakar.definirGanador();
    System.out.println("El vehiculo ganador de la carrera es:  " + ganador.getPatente());



    }
}
