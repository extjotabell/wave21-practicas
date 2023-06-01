package org.example;

public class Moto extends Vehiculo{

    public Moto(int velocidad, int aceleración, int anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        setPeso(300);
        setRuedas(2);
    }
}
