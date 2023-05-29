package models;

public class Moto extends Vehiculo{
    private static final Double PESO_DE_MOTO = 300.0;
    public static final int RUEDAS = 2;
    public Moto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente, PESO_DE_MOTO, RUEDAS);
    }
}
