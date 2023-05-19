public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Javier", 24, "345345");
        Persona persona3 = new Persona("Diego", 23, "123345", 79, 168);
        Persona persona4 = new Persona();

        System.out.println(persona3.calcularIMC());
        System.out.println(persona3.esMayorDeEdad());
    }
}