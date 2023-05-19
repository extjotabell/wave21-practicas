public class Main {
    public static void main(String[] args) {
        /*
        Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300
         de tipo int. Calcular el cociente de b/a. Controlar la excepción que se lanza
         indicando el mensaje “Se ha producido un error”. Al final del programa
         siempre deberá indicar el mensaje “Programa finalizado”
         */

        // Ejercicio 1
        PracticaExcepciones p = new PracticaExcepciones(0, 300);
        double result = p.calcularCociente1();
        if(result != -1){
            System.out.println(String.format("El Resultado de la division es: %f", result));
        }

        // Ejercicio 2
        p = new PracticaExcepciones(0, 300);
        result = p.calcularCociente2();
        if(result != -1){
            System.out.println(String.format("El Resultado de la division es: %f", result));
        }
    }
}