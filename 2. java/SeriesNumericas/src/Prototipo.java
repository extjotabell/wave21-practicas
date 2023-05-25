public abstract class Prototipo {
    protected int valorActual;
    public Prototipo(int valorInicial) {
        this.valorActual = valorInicial;
    }

    public abstract int obtenerValorSiguiente();

    public void reiniicarSerie(){
        valorActual = 0;
    }

    public void valorInicial(int valorInicial){
        this.valorActual = valorInicial;
    }
}
