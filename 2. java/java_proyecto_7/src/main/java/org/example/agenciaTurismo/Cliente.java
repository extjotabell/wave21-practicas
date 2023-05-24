package org.example.agenciaTurismo;

public class Cliente {
    private String nombre;
    private static int cantidadLocalizadores = 0;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadLocalizadores() {
        return cantidadLocalizadores;
    }

    public void addLocalizador() {
        cantidadLocalizadores += 1;
    }
}
