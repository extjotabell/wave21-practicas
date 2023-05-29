public class SerieInteger extends Prototipo<Integer>{
    public SerieInteger(Integer valor, Integer serie) {
        super(valor, serie);
    }

    @Override
    public void devolverSiguiente() {
        super.setValor( this.valor + this.serie);
        System.out.println(getValor());
    }
}
