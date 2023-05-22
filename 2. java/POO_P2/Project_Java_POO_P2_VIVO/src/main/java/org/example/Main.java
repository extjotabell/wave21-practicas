package org.example;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try {
            practicaExcepciones.calcular();
        } catch (ArithmeticException exception) {
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir poe cero");
        } finally {
            System.out.println("Programa finalizado");
        }


    }
}