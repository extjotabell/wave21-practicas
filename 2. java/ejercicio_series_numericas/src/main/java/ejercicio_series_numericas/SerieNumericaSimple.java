package ejercicio_series_numericas;

public class SerieNumericaSimple extends Prototipo<Integer>{
    public SerieNumericaSimple(Integer valorActual) {
        super(valorActual);
    }

    @Override
    public Integer devolverValorSiguiente() {
        Integer nuevoValor = super.getValorActual() + 2;
        super.setValorActual(nuevoValor);
        return nuevoValor;
    }
}
