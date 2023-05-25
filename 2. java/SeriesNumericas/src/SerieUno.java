public class SerieUno extends Prototipo{

    public SerieUno(int valorInicial) {
        super(valorInicial);
    }

    @Override
    public int obtenerValorSiguiente() {
        valorActual += 2;
        return valorActual;
    }
}
