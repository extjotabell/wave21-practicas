package org.example.AgenciaTurismo;

public class ReservaComida extends Reserva{
    private double costo = 20.0;

    public ReservaComida(String tipo) {
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
        return "ReservaComida{" +
                "costo=" + costo +
                ", tipo=" + super.getTipo() +
                '}';
    }
}
