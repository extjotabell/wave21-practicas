package org.example;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;


    public void cocienteExcepcionCatcheada(){
        int resultado;
        //tomamos el resultado como int para que se tire la excepción porque sino el resultado era "Infinity".

        try{
            resultado = this.b/this.a;
            System.out.println("Resultado de la división " + resultado);

        }catch(ArithmeticException e){
            try {
                throw new IllegalArgumentException("Se produjo un error");
            }
            catch(IllegalArgumentException ex){
                System.out.println("No se puede dividir por cero");
            }
        }
        finally {
            System.out.println("Programa finalizado");
        }

    }

}
