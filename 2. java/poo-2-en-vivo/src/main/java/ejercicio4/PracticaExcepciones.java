package ejercicio4;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int result;

        //Ejercicio 1 parte 1
        try{
            result = b / a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }

        //Ejercicio 1 parte 2
        try{
            result = b / a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
