package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int[][] temperaturas = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int tempMaxima = Integer.MIN_VALUE;
        int tempMinima = Integer.MAX_VALUE;
        int indiceMaxima = Integer.MIN_VALUE;
        int indiceMinima = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++){
            if( tempMinima > temperaturas[i][0])
            {
                tempMinima = temperaturas[i][0];
                indiceMinima = i;
            }
        }

        for (int i = 0; i < 10; i++){
            if(tempMaxima < temperaturas[i][1])
            {
                tempMaxima = temperaturas[i][1];
                indiceMaxima = i;
            }
        }

        System.out.println("La temperatura máxima fue en: " + ciudades[indiceMaxima] + " y fue de " + tempMaxima + " grados");
        System.out.println("La temperatura mínima fue en: " + ciudades[indiceMinima] + " y fue de " + tempMinima + " grados");

    }
}