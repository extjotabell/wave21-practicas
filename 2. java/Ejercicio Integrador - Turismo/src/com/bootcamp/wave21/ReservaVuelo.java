package com.bootcamp.wave21;

public class ReservaVuelo extends Reserva{
    private double costo;
    public ReservaVuelo(double costo){
        this.costo = costo;
    }
    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public String toString() {
        return "ReservaVuelo" +
                "costo=" + costo
                ;
    }
}
