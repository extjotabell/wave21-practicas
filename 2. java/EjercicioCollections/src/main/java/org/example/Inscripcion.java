package org.example;

public class Inscripcion {
    private int numInscripcion;
    private Categoria categoria;
    private Persona participante;
    private double monto;

    public Inscripcion(int numInscripcion, Categoria categoria, Persona participante, double monto) {
        this.numInscripcion = numInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }

    public int getNumInscripcion() {
        return numInscripcion;
    }

    public void setNumInscripcion(int numInscripcion) {
        this.numInscripcion = numInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Persona getParticipante() {
        return participante;
    }

    public void setParticipante(Persona participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
