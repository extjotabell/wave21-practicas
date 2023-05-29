package clases;

public abstract class Prototipo {

    protected Integer contador;
    protected Integer valorInicial;

    public abstract int valorSiguiente();

    public abstract void setValorInicial(Integer valorInicial);

    public abstract void reiniciarSerie();
}
