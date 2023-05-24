package Clases;

public class SerieDouble extends Prototipo<Double>{
    public SerieDouble(Double incremento) {
        super(incremento);
    }

    @Override
    public Double sumar(Double a, Double b) {
        return a + b;
    }
}
