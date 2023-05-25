package org.example.model;

import org.example.logic.Reserva;

public class Boletos extends Reserva {
    public Boletos(Double costo) {
        super(costo);
        this.setNombre("Boletos de Avión");
    }
}
