package org.example;

public class PracticaExcepciones {

    private int a;
    private int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public int calcularCociente() {
        try {
            if (a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            } else {
                double resultado = b / a;
                System.out.printf("El resultado es: %.2f\n", resultado);
            }
//        } catch (ArithmeticException e) {
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
//            return 0;
        } finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }
}
