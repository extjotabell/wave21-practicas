package org.example.serieNumerica;

public class Main {
    public static void main(String[] args) {
        SerieDeDos serieDeDos = new SerieDeDos(0);


        serieDeDos.valorSiguiente();
        System.out.println(serieDeDos.getValorActual());
        serieDeDos.valorSiguiente();
        System.out.println(serieDeDos.getValorActual());
        serieDeDos.valorSiguiente();
        System.out.println(serieDeDos.getValorActual());
        serieDeDos.valorSiguiente();
        System.out.println(serieDeDos.getValorActual());
        serieDeDos.valorSiguiente();
        System.out.println(serieDeDos.getValorActual());

        serieDeDos.reiniciarSerie();
        System.out.println(serieDeDos.getValorActual());


    }
}