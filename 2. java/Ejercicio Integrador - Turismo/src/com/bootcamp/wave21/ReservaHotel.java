package com.bootcamp.wave21;

public class ReservaHotel extends Reserva{
    private double costo ;
    public ReservaHotel(double costo){
        this.costo = costo;
    }
    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public String toString() {
        return "ReservaHotel" +
                "costo=" + costo;
    }
}
