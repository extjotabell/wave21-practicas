package org.example.AgenciaTurismo;

import java.util.List;

public class Cliente {
    private String nombre;
    private int dni;

    private List<Localizador> localizadores;

    public Cliente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public boolean tieneDescuento(){
        return this.localizadores.size() >=2;
    }
}