package org.example.dakar;

public class Moto extends Vehiculo {
    public static final double PESO = 300;
    public static final int RUEDAS = 2;

    public Moto(double velocidad, double aceleración, double ánguloDeGiro, String patente) {
        super(velocidad, aceleración, ánguloDeGiro, patente, PESO, RUEDAS);
    }
}
