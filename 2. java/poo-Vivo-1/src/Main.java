// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Ejercicio 4
        Persona primeraPersona = new Persona();
        Persona segundaPersona = new Persona("John", 18, "12345678");
        Persona terceraPersona = new Persona("Doe", 20, "98765432", 1.70, 80.2);

        // Ejercicio 6
        System.out.println("--------------------------------");
        System.out.println("Calculando IMC");
        int imcPersona = terceraPersona.calcularIMC();
        System.out.println("Resultado IMC = " + imcPersona);

        System.out.println("--------------------------------");
        System.out.println("Es mayor de edad?");
        boolean esMayorDeEdad = terceraPersona.esMayorDeEdad();
        System.out.println("Resultado = " + esMayorDeEdad);

        System.out.println("--------------------------------");
        System.out.println("Indice de Masa Corporal (IMC) = " + imcPersona);

        if (imcPersona < 0){
            System.out.println("Por debajo de 20 - Bajo Peso");
        } else if (imcPersona > 0) {
            System.out.println("Entre 20 y 25 inclusive - Sobrepeso");
        } else {
            // Igual a 0
            System.out.println("Mayor de 25 - Peso Saludable");
        }
    }
}