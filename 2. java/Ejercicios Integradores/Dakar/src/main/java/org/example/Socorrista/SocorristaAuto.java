package org.example.Socorrista;

import org.example.Vehiculo.Auto;
import org.example.Vehiculo.Vehiculo;

public class SocorristaAuto extends Socorrista {

    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo un auto de patente: " + unAuto.getPatente());
    }


}
