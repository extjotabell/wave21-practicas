public class SerieProgresiva {
    protected int valor;
    protected int incremento;

    public SerieProgresiva(int incremento) {
        this.incremento = incremento;
    }

    public int siguiente() {
        int siguienteValor = valor;
        valor += incremento;
        return siguienteValor;
    }

    public void reiniciar() {
        valor = 0;
    }

    public void establecerInicial(int valorInicial) {
        valor = valorInicial;
    }
}
