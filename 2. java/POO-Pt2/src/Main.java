// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PracticaExcepciones p = new PracticaExcepciones(0, 300);
        double result = p.calcularCociente();
        System.out.println(String.format("El Resultado de la division es: %f", result));
    }
}