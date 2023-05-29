package Ejercicio;

public abstract class Prototipo <T extends Number> {
    public abstract T valorSiguiente();
    public abstract void reiniciarSerie ();
    public abstract void valorInicial(T numero);
}
