package com.bootcamp.wave21;

public  abstract  class Reserva {
   private double costo;

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public abstract double getCosto();

}
