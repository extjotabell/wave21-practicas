package Ejercicio_abstract_Part1;

public abstract class Prototipo<T extends Number> {
    protected T valor;
    protected T valorInicial;

    public T nextSerie() {
        if (valor == null) {
            if (valorInicial == null) {
                throw new IllegalStateException("La serie no fue inicializada");
            }
            valor = valorInicial;
            return valor;
        }
        T siguiente = calcularSiguiente();
        valor = siguiente;
        return siguiente;
    }

    public void reset() {
        valor = null;
    }

    public void initSerie(T valorInicial) {
        this.valorInicial = valorInicial;
        reset();
    }

    protected abstract T calcularSiguiente();
}
