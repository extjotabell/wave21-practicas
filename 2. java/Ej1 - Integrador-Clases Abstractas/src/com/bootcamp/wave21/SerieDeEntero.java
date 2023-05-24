package com.bootcamp.wave21;


public class SerieDeEntero extends PrototipoSeries{

    private Integer numeroInicial;
    private Integer numeroActual;
    private Integer numeroDeSaltos;

    public SerieDeEntero(Integer numeroDeSaltos) {
        this.numeroDeSaltos = numeroDeSaltos;
    }

    @Override
    public void inicializarSerie(Number numero) {
        this.numeroActual = (Integer) numero;
        this.numeroInicial = (Integer) numero;
    }

    @Override
    public Number siguienteNumero() {
        return this.numeroActual += this.numeroDeSaltos;
    }

    @Override
    public void reiniciarNumero() {
        this.numeroActual = this.numeroInicial;
    }

    public Integer getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(Integer numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public Integer getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(Integer numeroActual) {
        this.numeroActual = numeroActual;
    }

    public Integer getNumeroDeSaltos() {
        return numeroDeSaltos;
    }

    public void setNumeroDeSaltos(Integer numeroDeSaltos) {
        this.numeroDeSaltos = numeroDeSaltos;
    }
}
