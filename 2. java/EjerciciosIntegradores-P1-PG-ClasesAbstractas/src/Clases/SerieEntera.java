package Clases;

public class SerieEntera extends Prototipo<Integer>{
    public SerieEntera(Integer incremento) {
        super(incremento);
    }

    @Override
    public Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}
