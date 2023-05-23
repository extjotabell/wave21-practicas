package PracticaPOO_Vivo2;

public class PracticaExcepciones {
    //Ejercicio 1 parte A

    /*public double division (int a, int b) {
        double divison;
        try {
            divison = b/a;
        }
        catch (ArithmeticException exception) {
            System.out.println("Se ha producido un error.");
        }
        finally {
            System.out.println("Programa finalizado.");
        }
        return division;
    }*/


    //Ejercicio 1 parte B
    public double Division (int a, int b) {
        double resultado = 0;
        try {
            if(a == 0)
            {
                throw new IllegalArgumentException("No se puede dividir entre 0");
            }
            else {
                resultado = b/a;
            }

        }
        catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Programa finalizado.");
        }
        return resultado;
    }
}
