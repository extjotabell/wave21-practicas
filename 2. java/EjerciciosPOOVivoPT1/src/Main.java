import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona1 = new Persona("Persona1", 18, "123456789");
        Persona persona2 = new Persona("Persona2", 22, "987654321", 100, 1.78);

        System.out.println("IMC = " + persona2.cacularIMC());
        System.out.println("Es mayor de edad = " + persona2.esMayorDeEdad());
        System.out.println("Información persona = " + persona2.toString());
    }
}