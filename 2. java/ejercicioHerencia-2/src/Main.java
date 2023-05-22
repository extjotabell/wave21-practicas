// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try{
            PracticaExcepciones prueba = new PracticaExcepciones();
            double resultado = 0.0;

            resultado = prueba.calcularCociente();

        }catch (IllegalArgumentException | ArithmeticException e ){
            System.out.println("No se puede dividir por 0");
        }

        System.out.println("Programa Finalizado");

    }
}