package org.example;


public class Moto extends Vehiculo{

    // es una variable constante que no puede ser modificada (final)
    public static final Double pesoMoto = 300.0;
    public static final Integer ruedasMoto = 2;


    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, pesoMoto, ruedasMoto);
    }

    @Override
    public String toString() {
        return "Moto{" + super.toString() + "}";
    }
}
