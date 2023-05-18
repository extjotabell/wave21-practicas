package org.example;

import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        public static void main(String[] args) {
                String ciudad[] = new String[10];
                ciudad[0] = "Londres";
                ciudad[1] = "Madrid";
                ciudad[2] = "Nueva York";
                ciudad[3] = "Buenos Aires";
                ciudad[4] = "Asunción";
                ciudad[5] = "Sao Pablo";
                ciudad[6] = "Lima";
                ciudad[7] = "Santiago de Chile";
                ciudad[8] = "Lisboa";
                ciudad[9] = "Tokio";


                int matrizTemperaturas[][] = new int[10][2];
                matrizTemperaturas[0][0] = -2;
                matrizTemperaturas[1][0] = -3;
                matrizTemperaturas[2][0] = -8;
                matrizTemperaturas[3][0] = 4;
                matrizTemperaturas[4][0] = 6;
                matrizTemperaturas[5][0] = 5;
                matrizTemperaturas[6][0] = 0;
                matrizTemperaturas[7][0] = -7;
                matrizTemperaturas[8][0] = -1;
                matrizTemperaturas[9][0] = -10;
                matrizTemperaturas[0][1] = 33;
                matrizTemperaturas[1][1] = 32;
                matrizTemperaturas[2][1] = 27;
                matrizTemperaturas[3][1] = 37;
                matrizTemperaturas[4][1] = 42;
                matrizTemperaturas[5][1] = 43;
                matrizTemperaturas[6][1] = 39;
                matrizTemperaturas[7][1] = 26;
                matrizTemperaturas[8][1] = 31;
                matrizTemperaturas[9][1] = 35;

                int f;
                int tempMin = 0;
                String ciudadMin ="";
                int tempMax = 0;
                String ciudadMax ="";

                for (f = 0; f < 10; f++) {
                        if (matrizTemperaturas[f][0] < tempMin){
                                tempMin = matrizTemperaturas[f][0];
                                ciudadMin = ciudad[f];
                        }
                }

                for (f = 0; f < 10; f++) {
                        if (matrizTemperaturas[f][1] > tempMax){
                                tempMax = matrizTemperaturas[f][1];
                                ciudadMax = ciudad[f];
                        }
                }

                System.out.println("La menor temperatura registrada fue " + tempMin + " en la ciudad "+ ciudadMin);
                System.out.println("La mayor temperatura registrada fue " + tempMax + " en la ciudad "+ ciudadMax);

        }
}
