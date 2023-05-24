package SeriesNumericas;

public class SerieDouble extends Prototipo{
    public SerieDouble(Double incremento) {
        super(incremento);
        valorActual = 0D;

    }

    public SerieDouble(Double incremento, Double valorInicial) {
        super(incremento, valorInicial);

    }
    @Override
    public Number obtenerProximoValor() {
        valorActual = valorActual.doubleValue() + incremento.doubleValue();
        return valorActual.doubleValue();
    }
}
