package org.example;

public class Auto extends Vehiculo{

    public Auto(int velocidad, int aceleración, int anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        setPeso(1000);
        setRuedas(4);
    }


}
