package org.example.model;

import org.example.logic.Reserva;
public class Hotel extends Reserva {
    public Hotel(Double costo) {
        super(costo);
        this.setNombre("Hotel");
    }
}
