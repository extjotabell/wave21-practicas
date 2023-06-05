package com.example.Deportistas;

public class Deporte {
    private String Nombre;
    private String Nivel;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public Deporte(String nombre, String nivel) {
        Nombre = nombre;
        Nivel = nivel;
    }

    public Deporte() {
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "Nombre='" + Nombre + '\'' +
                ", Nivel='" + Nivel + '\'' +
                '}';
    }
}
