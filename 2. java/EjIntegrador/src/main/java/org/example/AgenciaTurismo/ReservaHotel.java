package org.example.AgenciaTurismo;

public class ReservaHotel extends Reserva{

    private double costo = 25.0;


    public ReservaHotel(String tipo) {
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
        return "ReservaHotel{" +
                "costo=" + costo +
                ", tipo=" + super.getTipo() +
                '}';
    }
}
