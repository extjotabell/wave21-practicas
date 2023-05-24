package SeriesNumericas;

public class SerieEntera extends Prototipo{

    public SerieEntera(Integer incremento) {
        super(incremento);
        valorActual = 0;

    }

    public SerieEntera(Integer incremento, Integer valorInicial) {
        super(incremento, valorInicial);

    }

    @Override
    public Integer obtenerProximoValor() {
        valorActual = valorActual.intValue() + incremento.intValue();
        return valorActual.intValue();
    }

}
