package Ejercicio;

public abstract class Prototipo <T extends Number> {
    public abstract T valorSiguiente(T numero);
    public abstract void reiniciarSerie ();
    public abstract void valorInicial(T numero);
}
