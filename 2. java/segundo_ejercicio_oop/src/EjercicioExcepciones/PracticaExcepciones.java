package EjercicioExcepciones;

public class PracticaExcepciones {
    public static void calcularCociente() {
        try {
            int cociente = b / a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    private static int a = 0;
    private static int b = 300;
}
