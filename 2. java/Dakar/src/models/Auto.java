package models;

public class Auto extends Vehiculo{
    private static final Double PESO_DE_AUTO = 1000.0;
    public static final int RUEDAS = 4;
    public Auto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente, PESO_DE_AUTO, RUEDAS);
    }
}
