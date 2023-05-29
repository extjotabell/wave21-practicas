package org.example.AgenciaTurismo;

public abstract class Reserva {

    private String tipo;
//hotel, boletos de viaje, comida, transporte;
    private double costo;
    public Reserva(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
