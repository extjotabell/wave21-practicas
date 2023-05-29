package org.example.AgenciaTurismo;

public class ReservaTransporte extends Reserva{

    private double costo = 10.0;

    public ReservaTransporte(String tipo) {
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
        return "ReservaTransporte{" +
                "costo=" + costo +
                ", tipo=" + super.getTipo() +
                '}';
    }
}
