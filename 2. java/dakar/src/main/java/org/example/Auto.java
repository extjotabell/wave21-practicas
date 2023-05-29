package org.example;

import java.time.Period;

public class Auto extends Vehiculo {
  private static final double PESO_AUTO = 1000d;
  private static final int RUEDAS_AUTO = 4;
  public Auto(double velocidad, double aceleracion, double anguloGiro, String patente) {
    super(velocidad, aceleracion, anguloGiro, patente, PESO_AUTO, RUEDAS_AUTO);
  }


  @Override
  public String toString() {
    return String.format("Auto: %s", this.getPatente());
  }
}
