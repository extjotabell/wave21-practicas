package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        SerieInteger serie = new SerieInteger(0, 2);

        serie.valorSiguiente();
        serie.valorSiguiente();
        serie.valorSiguiente();
        serie.valorSiguiente();

        SerieInteger otraSerie = new SerieInteger(1,2);
        otraSerie.valorSiguiente();
        otraSerie.valorSiguiente();
        otraSerie.valorSiguiente();
        otraSerie.valorSiguiente();

        System.out.println("-----");

        otraSerie.reiniciarSucesion();
        System.out.println(otraSerie.sucesion);



    }
}