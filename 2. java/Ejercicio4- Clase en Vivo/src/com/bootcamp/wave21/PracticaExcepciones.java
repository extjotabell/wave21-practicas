package com.bootcamp.wave21;

public class PracticaExcepciones {

    public static void pruebaExcepciones(){
        int a = 0;
        int b = 300;
        int resultado;
        try{
           resultado = b/a;
        }catch(ArithmeticException e){
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero :S");
        }
    System.out.println("Programa finalizado");
    }
}
