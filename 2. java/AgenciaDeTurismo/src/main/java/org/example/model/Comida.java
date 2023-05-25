package org.example.model;

import org.example.logic.Reserva;
public class Comida extends Reserva {

    public Comida(Double costo) {
        super(costo);
        this.setNombre("Comida");
    }
}
