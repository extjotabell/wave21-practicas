import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Scanner keyboard = new Scanner(System.in);
        String countries[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temp[][] = new int[10][2];
        int min = 0;
        int max = 0;
        int indfiMin = 0;
        int indfiMax = 0;

        temp[0][0] = -2;
        temp[1][0] = -3;
        temp[2][0] = -8;
        temp[3][0] = 4;
        temp[4][0] = 6;
        temp[5][0] = 5;
        temp[6][0] = 0;
        temp[7][0] = -7;
        temp[8][0] = -1;
        temp[9][0] = -10;

        temp[0][1] = 33;
        temp[1][1] = 32;
        temp[2][1] = 27;
        temp[3][1] = 37;
        temp[4][1] = 42;
        temp[5][1] = 43;
        temp[6][1] = 39;
        temp[7][1] = 26;
        temp[8][1] = 31;
        temp[9][1] = 35;
        for (int f = 0; f < 10; f++) {
            if (temp[f][0] <= min) {
                min = temp[f][0];
                indfiMin = f;
            }
            if(temp[f][1] > max){
                max = temp[f][1];
                indfiMax = f;
            }
        }
        System.out.println("La menor temperatura la tuvo "+ countries[indfiMin] + ", con " + min + "º C.");
        System.out.println("La mayor temperatura la tuvo "+ countries[indfiMax] + ", con " + max + "º C.");
    }
}