package org.example;

public class Auto extends Vehiculo {

    private static final Double pesoAuto = 1000.0;
    public static final int ruedas = 4;

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, pesoAuto, ruedas);
    }


    @Override
    public String toString() {
        return "Auto{" + super.toString() + "}";
    }
}
