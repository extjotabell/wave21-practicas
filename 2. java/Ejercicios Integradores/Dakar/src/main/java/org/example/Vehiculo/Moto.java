package org.example.Vehiculo;

public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleración, double anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        this.setPeso(300);
        ruedas = new String[2];
        String ruedasAux[];
        ruedasAux = new String[]{"Rueda1", "Rueda2"};
        setRuedas(ruedasAux);
    }
}
