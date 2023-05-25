public class SerieDos extends Prototipo{
    public SerieDos(int valorInicial) {
        super(valorInicial);
    }

    @Override
    public int obtenerValorSiguiente() {
        valorActual += 3;
        return valorActual;
    }
}
