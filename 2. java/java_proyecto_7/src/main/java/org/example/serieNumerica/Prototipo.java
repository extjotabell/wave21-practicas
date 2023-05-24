package org.example.serieNumerica;

public abstract class Prototipo <T extends Number>{
    private T inicio;
    protected T valorActual;
    protected T salto;

    public abstract T valorSiguiente();

    public Prototipo(T inicio, T salto) {
        this.inicio = inicio;
        this.valorActual = inicio;
        this.salto = salto;
    }

    public void reiniciarSerie(){
        valorActual = inicio;
    }

    public void valorInicial(T inicio){
        valorActual = inicio;
    }

    public T getValorActual() {
        return valorActual;
    }
}
