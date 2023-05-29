package Ejercicio;

public class SeriesDeDos<T extends Number> extends Prototipo<T> {
    private T valor;
    @Override
    public T valorSiguiente() {
        Number siguente = 2 + (int)(valor);
        valor = (T)siguente;
        return valor;
    }

    @Override
    public void reiniciarSerie() {
        valor = (T)0;
    }

    @Override
    public void valorInicial(T numero) {
        this.valor = numero;
    }

}
