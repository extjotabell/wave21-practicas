package EjercicioAbstractas;

public abstract class Prototipo {

    private Integer valorInicial;
    private Integer valorActual;

    public Integer getValorActual() {
        return valorActual;
    }

    public void setValorActual(Integer valorActual) {
        this.valorActual = valorActual;
    }


    public Integer getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract Integer valorSiguiente();

    public void reiniciarSerie() {
        setValorActual(getValorInicial());
    }

    public void reestablecerSerie(Integer valor) {
        setValorInicial(valor);
        setValorActual(valor);
    }

}
