package com.bootcamp.wave21;

public abstract class PrototipoSeries <T extends Number>{

    public abstract void inicializarSerie(T numero);
    public abstract T siguienteNumero();
    public abstract void reiniciarNumero();

}
