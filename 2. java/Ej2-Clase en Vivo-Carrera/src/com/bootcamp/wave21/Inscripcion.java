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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inscripcion)) return false;

        Inscripcion that = (Inscripcion) o;

        if (Double.compare(that.monto, monto) != 0) return false;
        if (participante != null ? !participante.equals(that.participante) : that.participante != null) return false;
        return circuito != null ? circuito.equals(that.circuito) : that.circuito == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = participante != null ? participante.hashCode() : 0;
        temp = Double.doubleToLongBits(monto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (circuito != null ? circuito.hashCode() : 0);
        return result;
    }
}
