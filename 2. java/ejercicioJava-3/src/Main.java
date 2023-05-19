// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona("gabriel", 32, "30333222", 30.2, 1.68 );
        Persona persona2 = new Persona("tamara", 28, "45000300");
        Persona persona3 = new Persona();

        persona1.tostring();
        persona2.tostring();
        persona3.tostring();

        System.out.println("indice de masa corporal (IMC) " + "\t\t" + "Nivel de peso");
        System.out.println( "\t\t\t"+ persona1.calcularIMC() + "\t\t\t\t\t\t" + persona1.messageIMC());

        //System.out.println("EL IMC de la persona Ingresada es : "+ Math.round(IMC));
    }



}