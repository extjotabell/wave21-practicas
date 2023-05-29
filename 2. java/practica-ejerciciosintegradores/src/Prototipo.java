public abstract class Prototipo<T extends Number> {
    T valor;
    T serie;
    T valorInicial;
    public Prototipo(T valorInicial,T serie) {
        this.valor = valorInicial;
        this.serie = serie;
        this.valorInicial = valorInicial;
    }

    public abstract void devolverSiguiente();

    public T getValorInicial() {
        return valorInicial;
    }
    public void reiniciarValorSerie(){
        setValor(valorInicial);
    }
    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public T getSerie() {
        return serie;
    }

    public void setSerie(T serie) {
        this.serie = serie;
    }
}
