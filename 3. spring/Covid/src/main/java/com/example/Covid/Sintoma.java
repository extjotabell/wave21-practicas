package com.example.Covid;

public class Sintoma {
    private int numero;
    private String nombre;
    private String gravedad;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public Sintoma(int numero, String nombre, String gravedad) {
        this.numero = numero;
        this.nombre = nombre;
        this.gravedad = gravedad;
    }

    public Sintoma() {
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", gravedad='" + gravedad + '\'' +
                '}';
    }
}
