package ejercicio_series_numericas;

public class SerieBytes extends Prototipo<Byte>{
    public SerieBytes(Byte valorActual) {
        super(valorActual);
    }

    @Override
    public Byte devolverValorSiguiente() {
        Byte nuevoValor = (byte) (super.getValorActual() + (byte)2);
        super.setValorActual(nuevoValor);
        return nuevoValor;
    }
}
