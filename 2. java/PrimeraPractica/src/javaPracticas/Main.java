package javaPracticas;

public class Main {
    public static void main(String[] args) {

        String cities[] = new String[10];
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asuncion";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        int temperature[][] = new int[10][2];
        temperature[0][0] = -2;
        temperature[0][1] = 33;
        temperature[1][0] = -3;
        temperature[1][1] = 32;
        temperature[2][0] = -8;
        temperature[2][1] = 27;
        temperature[3][0] = 4;
        temperature[3][1] = 37;
        temperature[4][0] = 6;
        temperature[4][1] = 42;
        temperature[5][0] = 5;
        temperature[5][1] = 43;
        temperature[6][0] = 0;
        temperature[6][1] = 39;
        temperature[7][0] = -7;
        temperature[7][1] = 26;
        temperature[8][0] = -1;
        temperature[8][1] = 31;
        temperature[9][0] = -10;
        temperature[9][1] = 35;

        int tempMax = Integer.MIN_VALUE;
        int temMin = Integer.MAX_VALUE;
        int posMax = 0;
        int posMin = 0;

        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j <=1; j++) {
                if(temperature[i][j] > tempMax){
                    tempMax = temperature[i][j];
                    posMax = i;
                }
                if(temperature[i][j] < temMin) {
                    temMin = temperature[i][j];
                    posMin = i;
                }
            }
        }


        System.out.println("La menor temperatura la tuvo " + cities[posMin] + ", con " + temMin + " grados.");
        System.out.println("La mayor temperatura la tuvo " + cities[posMax] + ", con " + tempMax + " grados.");

    }
}