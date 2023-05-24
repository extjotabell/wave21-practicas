package com.bootcamp.wave21;

public class ReservaTransporte extends Reserva{

    private double costo;
    public ReservaTransporte(double costo){
        this.costo = costo;
    }
    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public String toString() {
        return "ReservaTransporte" +
                "costo=" + costo
                ;
    }
}
