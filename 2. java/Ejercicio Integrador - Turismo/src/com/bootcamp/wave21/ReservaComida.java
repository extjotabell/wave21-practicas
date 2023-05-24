package com.bootcamp.wave21;

public class ReservaComida extends Reserva{
    private double costo;
    public ReservaComida(double costo){
        this.costo = costo;
    }
    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public String toString() {
        return "ReservaComida" +
                "costo=" + costo
                ;
    }
}
