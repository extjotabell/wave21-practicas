import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
        int[][] temperaturas = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35},
        };

        int temperaturaMinima = temperaturas[0][0];
        int posicionTempMinima = 0;
        int temperaturaMaxima = temperaturas[0][1];
        int posicionTempMaxima = 0;

        for(int i = 0; i < temperaturas.length; i++){
            int temperaturaMinInFor = temperaturas[i][0];
            int temperaturaMaxInFor = temperaturas[i][1];

            if(temperaturaMinInFor < temperaturaMinima) {
                temperaturaMinima = temperaturaMinInFor;
                posicionTempMinima = i - 1;
            }
            if(temperaturaMaxInFor > temperaturaMaxima) {
                temperaturaMaxima = temperaturaMaxInFor;
                posicionTempMaxima = i - 1;
            }
        }

        System.out.println("La temperatura máxima es = " + temperaturaMaxima + " de la ciudad = " + ciudades[posicionTempMaxima]);
        System.out.println("La temperatura minima es = " + temperaturaMinima + " de la ciudad = " + ciudades[posicionTempMinima]);

    }
}