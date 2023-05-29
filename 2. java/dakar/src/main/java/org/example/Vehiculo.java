package org.example;

public abstract class Vehiculo {
  private double velocidad;
  private double aceleracion;
  private double anguloGiro;
  private String patente;
  private double peso;
  private int ruedas;

  public Vehiculo(double velocidad, double aceleracion, double anguloGiro, String patente, double peso, int ruedas) {
    this.velocidad = velocidad;
    this.aceleracion = aceleracion;
    this.anguloGiro = anguloGiro;
    this.patente = patente;
    this.peso = peso;
    this.ruedas = ruedas;
  }

  public void printStats() {
    System.out.println("Vehiculo "+this.patente+" indice: ~"+Math.round(this.calcularIndiceDeCarrera())+" "+this.velocidad+" "+this.aceleracion+" "+this.anguloGiro+" "+this.peso+" "+this.ruedas);
  }
  public double calcularIndiceDeCarrera() {
    return this.velocidad * (this.aceleracion / 2) / (this.anguloGiro*(this.peso-this.ruedas*100));
  }

  public double getVelocidad() {
    return velocidad;
  }

  public void setVelocidad(double velocidad) {
    this.velocidad = velocidad;
  }

  public double getAceleracion() {
    return aceleracion;
  }

  public void setAceleracion(double aceleracion) {
    this.aceleracion = aceleracion;
  }

  public double getAnguloGiro() {
    return anguloGiro;
  }

  public void setAnguloGiro(double anguloGiro) {
    this.anguloGiro = anguloGiro;
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
