package com.bootcamp.wave21;

public class SocorristaAuto extends Socorrista{

    @Override
    public void socorrer(Vehiculo veh) {
        System.out.println("Socorriendo un Auto con patente " +veh.getPatente());
    }
}
