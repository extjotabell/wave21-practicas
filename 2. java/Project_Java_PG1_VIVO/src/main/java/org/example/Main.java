package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        String cities[] = { "Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asuncion", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};
        int temperature[][] = {{ -2, -3, -8, 4, 6, 5, 0, -7, -1, -10},{33, 32, 27, 37, 42, 43, 39, 26, 31, 35}};

        int min = 0;
        int max = 0;

        String lowcity = "";
        String highcity = "";

        for(int i=0; i<2; i++) {
            for (int e=0; e<10; e++) {
                if (min > temperature[0][e]) {
                    min = temperature[0][e];
                    lowcity = cities[e];
;                }
                if (max < temperature[1][e]) {
                    max = temperature[1][e];
                    highcity = cities[e];
                }
            }
        }
        System.out.println("La temperatura mas baja es de Cº: " + min + " en la cuidad de " + lowcity);
        System.out.println("La temperatura mas alta es de Cº: " + max + " en la cuidad de " + highcity);

    }
}