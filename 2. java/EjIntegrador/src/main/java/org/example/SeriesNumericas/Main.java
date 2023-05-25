package org.example.SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------Ejercicio Series Numericas----------\n");
        System.out.println("Nueva serie sumando 2");
        Prototipo serieSumada1= new Sumador(2,2);
        serieSumada1.siguienteValor();
        serieSumada1.siguienteValor();
        serieSumada1.siguienteValor();
        System.out.println("Vamos a reiniciar");
        serieSumada1.reiniciar();
        serieSumada1.siguienteValor();
        serieSumada1.siguienteValor();
        serieSumada1.iniciar(3);
        serieSumada1.siguienteValor();
        serieSumada1.siguienteValor();

        System.out.println("\nNueva serie multiplicando x2");
        Prototipo serieMultiplicada1= new Multiplicador(2,2);
        serieMultiplicada1.siguienteValor();
        serieMultiplicada1.siguienteValor();
        serieMultiplicada1.siguienteValor();
        System.out.println("Vamos a reiniciar");
        serieMultiplicada1.reiniciar();
        serieMultiplicada1.siguienteValor();
        serieMultiplicada1.siguienteValor();
        serieMultiplicada1.iniciar(3);
        serieMultiplicada1.siguienteValor();
        serieMultiplicada1.siguienteValor();

        System.out.println("\nNueva serie multiplicando x3");
        Prototipo serieMultiplicada2= new Multiplicador(3, 3);
        serieMultiplicada2.siguienteValor();
        serieMultiplicada2.siguienteValor();
        serieMultiplicada2.siguienteValor();
        System.out.println("Vamos a reiniciar");
        serieMultiplicada2.reiniciar();
        serieMultiplicada2.siguienteValor();
        serieMultiplicada2.siguienteValor();
        serieMultiplicada2.iniciar(2);
        serieMultiplicada2.siguienteValor();
        serieMultiplicada2.siguienteValor();
    }
}
