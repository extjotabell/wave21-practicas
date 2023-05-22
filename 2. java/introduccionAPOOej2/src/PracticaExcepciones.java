// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PracticaExcepciones {
    public static void main(String[] args) {
       //Ejercicio 1
        int a = 0;
        int b = 300;
        double resultado = 0;

        try {
            resultado = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
            //System.out.println("Se ha producido un error" + e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}