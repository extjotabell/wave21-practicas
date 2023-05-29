package org.example.Vehiculo;

public abstract class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;

    private String patente;

    protected double peso;
    protected String ruedas[];

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleración() {
        return aceleracion;
    }

    public void setAceleración(double aceleración) {
        this.aceleracion = aceleración;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(String[] ruedas) {
        this.ruedas = ruedas;
    }

    public Double obtenerRanking() {
        return velocidad * (0.5 * aceleracion) / (anguloDeGiro* (peso- ruedas.length * 100));
    }
}
