package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String ciudades[] = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "New York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        //filas (ciudades) - columas (0 -> mínimas ; 1 -> máximas)
        int temperaturas[][] = new int [10][2];
        //londres
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        //madrid
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        // new york
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        //bs as
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        //asunción
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        //san pablo
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        //lima
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        //santiago
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        //lisboa
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        //tokio
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int indiceMenorTemp = 0;
        int i=0;
        int temperaturaMinima = temperaturas[i][0];

        for (i = 0; i < ciudades.length; i++) {
            int temperaturaMinimaActual = temperaturas[i][0];
            if(temperaturaMinimaActual <= temperaturaMinima ){
                indiceMenorTemp = i;
                temperaturaMinima = temperaturas[i][0];
            }
        }

        int indiceMayorTemp = 0;
        int j = 0;

        int temperaturaMaxima = temperaturas[j][1];

        for (j = 0; j < ciudades.length; j++){
            int temperaturaMaxActual = temperaturas[j][1];
            if(temperaturaMaxActual >= temperaturaMaxima) {
                indiceMayorTemp = j;
                temperaturaMaxima = temperaturas[j][1];
            }

        }

        System.out.println("La ciudad con la mayor temperatura registrada es " + ciudades[indiceMayorTemp]);
        System.out.println("La ciudad con menor temperatura registrada es " + ciudades[indiceMenorTemp]);


    }
}