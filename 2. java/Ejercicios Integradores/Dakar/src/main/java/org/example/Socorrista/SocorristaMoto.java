package org.example.Socorrista;

import org.example.Vehiculo.Moto;

public class SocorristaMoto extends Socorrista{

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo una moto de patente: " + unaMoto.getPatente());
    }

}
