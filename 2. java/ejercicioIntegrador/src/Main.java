import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String countries[] = new String[10];
        int temp[][] = new int[10][2];

        for (int i = 1; i <= 5; i++) {
            System.out.println("Ingrese pais:");
            countries[i] = keyboard.nextLine();
        }
    }
}