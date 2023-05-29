package com.bootcamp.wave21;

public abstract class Vehiculo {
   private double velocidad;
   private double aceleración;
   private double anguloDeGiro;
   private String patente;
   private double peso;
   private int ruedas;

    public Vehiculo() {
    }

    public  Vehiculo(double peso, int ruedas){
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double obtenerResumenCarrera(){

       return this.getVelocidad() * (0.5 * this.getAceleración())/(this.getAnguloDeGiro()*(this.getPeso()-this.getRuedas()*100));
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleración() {
        return aceleración;
    }

    public void setAceleración(double aceleración) {
        this.aceleración = aceleración;
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

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }


}
