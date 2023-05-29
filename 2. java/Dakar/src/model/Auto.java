package model;

public class Auto extends Vehiculo{
    public Auto(int velocidad, float aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }
}
