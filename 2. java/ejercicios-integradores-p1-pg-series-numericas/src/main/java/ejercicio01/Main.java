package ejercicio01;

public class Main {
    public static void main(String[] args) {
        Clase1 clase1 = new Clase1(2, 2);
        clase1.reset();
        clase1.setInterval(5);
        clase1.setInitialValue(9);
        clase1.printSerie();
        System.out.println("\n\n");

        Clase2 clase2 = new Clase2(0,0);
        clase2.reset();
        clase2.setInitialValue(58);
        clase2.setInterval(2);
        clase2.printSerie();
    }
}
