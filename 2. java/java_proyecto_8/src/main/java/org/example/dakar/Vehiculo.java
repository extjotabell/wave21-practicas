package org.example.dakar;

public abstract class Vehiculo {
    private double velocidad;
    private double aceleración;
    private double ánguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double aceleración, double ánguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleración = aceleración;
        this.ánguloDeGiro = ánguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleración() {
        return aceleración;
    }

    public double getÁnguloDeGiro() {
        return ánguloDeGiro;
    }

    public double getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleración=" + aceleración +
                ", ánguloDeGiro=" + ánguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
