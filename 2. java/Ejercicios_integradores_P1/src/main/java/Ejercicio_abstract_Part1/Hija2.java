package Ejercicio_abstract_Part1;

public class Hija2 <T extends Number> extends Prototipo<T>{
    private int multiplicador;

    public Hija2(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public T calcularSiguiente() {
        if (valor == null) {
            throw new IllegalStateException("La serie fue inicializada");
        }
        if (valor instanceof Integer) {
            int siguiente = ((Integer) valor) * multiplicador;
            return (T) Integer.valueOf(siguiente);
        } else if (valor instanceof Double) {
            double siguiente = ((Double) valor) * multiplicador;
            return (T) Double.valueOf(siguiente);
        } else {
            throw new UnsupportedOperationException("Tipo de dato no soportado");
        }
    }
}