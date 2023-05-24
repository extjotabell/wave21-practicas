package org.example.AgenciaTurismo;

public class ReservaBoletosViaje extends Reserva{
    private double costo = 800.0;


    public ReservaBoletosViaje(String tipo) {
        super(tipo);
    }

    @Override
    public double getCosto() {
        return costo;
    }

    @Override
    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "ReservaBoletosViaje{" +
                "costo=" + costo +
                ", tipo=" + super.getTipo() +
                '}';
    }
}
