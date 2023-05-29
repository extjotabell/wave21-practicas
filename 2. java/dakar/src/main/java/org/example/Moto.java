package org.example;

public class Moto extends Vehiculo {
  private static final double PESO_MOTO = 300d;
  private static final int RUEDAS_MOTO = 2;
  public Moto(double velocidad, double aceleracion, double anguloGiro, String patente) {
    super(velocidad, aceleracion, anguloGiro, patente, PESO_MOTO, RUEDAS_MOTO);
  }

  @Override
  public String toString() {
    return String.format("Moto: %s", this.getPatente());
  }
}
