package org.example.SeriesNumericas;

//La clase prototipo contendrá tres métodos. El primero de los métodos
// es el encargado de devolver un número que corresponderá al valor siguiente a la serie progresiva.
// Otro método para reiniciar la serie,
// y un último que recibirá un valor que servirá para establecer el valor inicial de la serie.
public abstract class Prototipo <T extends Number>{

    protected T nInicial;
    protected T nIncrementador;
    protected T valorActual;
    protected abstract T siguienteValor();
    public void reiniciar(){
        valorActual=nInicial;
        System.out.println(valorActual);
    }

    public void setNInicial(T nuevoValor){
        nInicial=nuevoValor;
    }
    public void setNIncrementador(T nuevoIncrementador){
        nIncrementador = nuevoIncrementador;
    };

    public void setValorActual(T nuevoValorActual){
        valorActual = nuevoValorActual;
    }
    public void iniciar(T nuevoNInicial){
        System.out.println("Seteando nuevo inicio");
        valorActual = nuevoNInicial;
        System.out.println(valorActual);
    };

}
