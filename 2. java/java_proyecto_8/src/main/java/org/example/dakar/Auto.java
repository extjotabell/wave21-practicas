package org.example.dakar;

public class Auto extends Vehiculo{
    public static final double PESO = 1000;
    public static final int RUEDAS = 4;


    public Auto(double velocidad, double aceleración, double ánguloDeGiro, String patente) {
        super(velocidad, aceleración, ánguloDeGiro, patente, PESO, RUEDAS);
    }
}
