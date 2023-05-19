package com.bootcamp.wave21;

public class Inscripcion {
    Participante participante;
    double monto;
    Circuito circuito;

    public Inscripcion() {

    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public String mostrarInscripcion(){

        return participante.mostrarParticipante() + " Categoria: " + this.getCircuito().mostrarCircuito() + " Monto: " + this.getMonto();
    }
}
