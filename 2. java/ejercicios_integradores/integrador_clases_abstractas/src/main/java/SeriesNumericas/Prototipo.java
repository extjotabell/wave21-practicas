package SeriesNumericas;

public abstract class Prototipo <T extends Number>{
    protected T valorInicial;
    protected T valorActual;
    protected T incremento;

    public Prototipo(T incremento) {
        this.incremento = incremento;
        valorInicial = incremento;
    }

    public Prototipo(T incremento, T valorInicial) {
        this.incremento = incremento;
        valorActual = valorInicial;
    }

    public abstract T obtenerProximoValor();

    public void reiniciarSerie(){
        valorActual = valorInicial;
    };

    public void setValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
    }


}
