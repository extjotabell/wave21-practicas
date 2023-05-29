package Ejercicio_abstract_Part1;

public class Hija1<T extends Number> extends Prototipo<T> {
    private int incremento;

    public Hija1(int incremento) {
        this.incremento = incremento;
    }

    @Override
    public T calcularSiguiente() {
        if (valor == null) {
            throw new IllegalStateException("La serie fue inicializada");
        }
        if (valor instanceof Integer) {
            int siguiente = ((Integer) valor) + incremento;
            return (T) Integer.valueOf(siguiente);
        } else if (valor instanceof Double) {
            double siguiente = ((Double) valor) + incremento;
            return (T) Double.valueOf(siguiente);
        } else {
            throw new UnsupportedOperationException("Tipo de dato no soportado");
        }
    }
}
