package Clases;

public abstract class Prototipo <T extends Number>{
    private T valorActual;
    private T incremento;

    public Prototipo(T incremento) {
        this.incremento = incremento;
        this.valorActual = incremento;
    }

    public T valorSiguiente(){
        T valor = valorActual;
        valorActual = sumar(valorActual, incremento);
        return valor;
    }

    public void reiniciar(){
        valorActual = incremento;
    }

    public void establecerValorInicio(T valorInicial){
        valorActual = valorInicial;
    }

    public abstract T sumar(T a, T b);
}
