package org.example.Ejercicio1;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try{
            double resultado = b / a;
            System.out.println(resultado);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
//            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
