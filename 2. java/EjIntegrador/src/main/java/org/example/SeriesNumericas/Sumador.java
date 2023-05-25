package org.example.SeriesNumericas;
public class Sumador <T extends Number> extends Prototipo <T>{
    public Sumador(T nIncrementador, T valorInicial) {
        setNIncrementador(nIncrementador);
        setNInicial(valorInicial);
        reiniciar();
    }
    @Override
    public T siguienteValor() {
        if (valorActual instanceof Integer) {
            Integer result = (Integer) valorActual + (Integer) nIncrementador;
            setValorActual((T) result);
            System.out.println(result);
            return (T) result;
        } else if (valorActual instanceof Double) {
            Double result = (Double) valorActual + (Double) nIncrementador;
            setValorActual((T) result);
            System.out.println(result);
            return (T) result;
        } else {
            System.out.println("Por favor, ingrese un número que no sea primitivo");
            return null;
        }
    }
}
