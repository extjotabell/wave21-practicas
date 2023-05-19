package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Declaracion e Inicializacion
        String vecCiudades[] = new String[10];
        int matTemperaturas[][] = new int[10][2];
        int temperaturaMin, temperaturaMax;
        String ciudadMin, ciudadMax;

        //Carga manual ciudades
        vecCiudades[0] = "Londres";
        vecCiudades[1] = "Madrid";
        vecCiudades[2] = "Nueva York";
        vecCiudades[3] = "Buenos Aires";
        vecCiudades[4] = "Asuncion";
        vecCiudades[5] = "Sao Paulo";
        vecCiudades[6] = "Lima";
        vecCiudades[7] = "Santiago de Chile";
        vecCiudades[8] = "Lisboa";
        vecCiudades[9] = "Tokio";

        //Carga manual Temperaturas
        matTemperaturas[0][0] = -2;
        matTemperaturas[0][1] = 33;
        matTemperaturas[1][0] = -3;
        matTemperaturas[1][1] = 32;
        matTemperaturas[2][0] = -8;
        matTemperaturas[2][1] = 27;
        matTemperaturas[3][0] = 4;
        matTemperaturas[3][1] = 37;
        matTemperaturas[4][0] = 6;
        matTemperaturas[4][1] = 42;
        matTemperaturas[5][0] = 5;
        matTemperaturas[5][1] = 43;
        matTemperaturas[6][0] = 0;
        matTemperaturas[6][1] = 39;
        matTemperaturas[7][0] = -7;
        matTemperaturas[7][1] = 26;
        matTemperaturas[8][0] = -1;
        matTemperaturas[8][1] = 31;
        matTemperaturas[9][0] = -10;
        matTemperaturas[9][1] = 35;

        //Variables auxiliares
        temperaturaMin = matTemperaturas[0][0];
        ciudadMin = vecCiudades[0];
        temperaturaMax = matTemperaturas[0][0];
        ciudadMax = vecCiudades[0];

        //Recorrido para encontrar la temperatura mínima y máxima
        for (int i=0; i<matTemperaturas.length; i++){
            for (int j=0; j<=1; j++){
                //Condicion para la temperatura minima
                if(matTemperaturas[i][j]<temperaturaMin){
                    temperaturaMin=matTemperaturas[i][j];
                    ciudadMin=vecCiudades[i];
                }
                if(matTemperaturas[i][j]>temperaturaMax){
                    temperaturaMax=matTemperaturas[i][j];
                    ciudadMax=vecCiudades[i];
                }
            }
        }
        //Reporte Temperaturas globales
        System.out.println("La ciudad de " + ciudadMin + " es la ciudad con la temperatura mínima de: " + temperaturaMin);
        System.out.println("La ciudad de " + ciudadMax + " es la ciudad con la temperatura máxima de: " + temperaturaMax);




    }
}