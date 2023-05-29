package org.example.Vehiculo;

public class Auto extends Vehiculo {


    public Auto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        this.setPeso(1000);
        ruedas = new String[4];
        String ruedasAux[];
        ruedasAux = new String[]{"Rueda1", "Rueda2", "Rueda3", "Rueda4"};
        setRuedas(ruedasAux);

    }
}
