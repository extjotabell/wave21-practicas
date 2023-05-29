package com.bootcamp.wave21;

public class SocorristaMoto extends Socorrista{
    @Override
    public void socorrer(Vehiculo veh) {
        System.out.println("Socorriendo una moto con patente " +veh.getPatente());
    }
}
