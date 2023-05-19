// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            Persona persona1 = new Persona();
            Persona persona2 = new Persona("Juan", 25, "45466554");
            Persona persona3 = new Persona("Juan", 18, "4784454878", 75, 1.79);

            int imc = persona3.calcularIMC();
            switch (imc) {
                case -1:
                    System.out.println(persona3.nombre + " tiene bajo peso");
                    break;
                case 0:
                    System.out.println(persona3.nombre + " tiene peso saludable");
                    break;
                case 1:
                    System.out.println(persona3.nombre + " tiene sobrepeso");
                    break;
            }
            boolean esMayor = persona3.esMayorDeEdad();
            if (esMayor) {
                System.out.println(persona3.nombre + " es mayor de edad");
            } else {
                System.out.println(persona3.nombre + " es menor de edad");
            }
    }
}