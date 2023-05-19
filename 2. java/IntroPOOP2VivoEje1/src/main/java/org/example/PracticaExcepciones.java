package org.example;

import java.util.PriorityQueue;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 330;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calcularCociente(){
        return this.b/this.a;
    }

    public static void main(String[] args) {

        PracticaExcepciones parcticaExp = new PracticaExcepciones(0,300);
        try {
            parcticaExp.calcularCociente();
        } catch (IllegalArgumentException exp) {
            System.out.println("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado");
        }


    }
}
