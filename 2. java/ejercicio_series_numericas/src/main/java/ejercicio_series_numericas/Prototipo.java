package ejercicio_series_numericas;

public abstract class Prototipo<T extends Number> {

    public Prototipo(T valorActual) {
        this.valorActual = valorActual;
    }

    public abstract T devolverValorSiguiente();
    public void reiniciarSerie(){
        this.valorActual = valorInicial;
    }
    public void setValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
    }

    protected T getValorActual() {
        return valorActual;
    }

    protected void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    private T valorInicial;
    private T valorActual;
}
