package Ejercicio;

public class SeriesDeDos<T extends Number> extends Prototipo<T> {
    private T inicial;
    @Override
    public T valorSiguiente(T numero) {
        Number siguente = 2 + (int)(numero);
        return (T)siguente;
    }

    @Override
    public void reiniciarSerie() {
        System.out.flush();
    }

    @Override
    public void valorInicial(T numero) {
        this.inicial = numero;
    }

}
