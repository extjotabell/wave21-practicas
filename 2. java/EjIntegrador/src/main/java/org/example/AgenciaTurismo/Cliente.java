package org.example.AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private int dni;

    private List<Localizador> localizadores;

    public void imprimirLocalizadores(){
        System.out.println("El cliente "+nombre+ " DNI Nª: "+dni+ " tiene los siguientes localizadores contratados:");
        for (int i = 0; i<this.localizadores.size(); i++){
            System.out.println("-" + this.localizadores.get(i));
        }
    }

    public Cliente(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.localizadores= new ArrayList<>();
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