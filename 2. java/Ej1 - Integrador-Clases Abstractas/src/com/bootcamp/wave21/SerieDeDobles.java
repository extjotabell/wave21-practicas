package com.bootcamp.wave21;

public class SerieDeDobles extends PrototipoSeries{

    private Double numeroInicial;
    private Double numeroActual;
    private Double numeroDeSaltos;

    public SerieDeDobles(Double numeroDeSaltos) {
        this.numeroDeSaltos = numeroDeSaltos;
    }

    @Override
    public void inicializarSerie(Number numero) {
        this.numeroActual = (Double) numero;
        this.numeroInicial = (Double) numero;
    }

    @Override
    public Number siguienteNumero() {
        return this.numeroActual += this.numeroDeSaltos;
    }

    @Override
    public void reiniciarNumero() {
        this.numeroActual = this.numeroInicial;
    }

    public Double getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(Double numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public Double getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(Double numeroActual) {
        this.numeroActual = numeroActual;
    }

    public Double getNumeroDeSaltos() {
        return numeroDeSaltos;
    }

    public void setNumeroDeSaltos(Double numeroDeSaltos) {
        this.numeroDeSaltos = numeroDeSaltos;
    }
}
