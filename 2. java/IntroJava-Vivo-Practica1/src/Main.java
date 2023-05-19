import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Declaracion de las Ciudades
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokyo"};

        // Declaracion de las temperaturas.
        // Cada Indice de fila representa una ciudad.
        int[][] temperaturas = {
                {-2, 33}, // Londres
                {-3, 32}, // Madrid
                {-8, 27}, // Nueva York
                {4, 37}, // Buenos Aires
                {6, 42}, // Asuncion
                {5, 43}, // Sao Pablo
                {0, 39}, // Lima
                {-7, 26}, // Santiago de Chile
                {-1, 31}, // Lisboa
                {-10, 35} // Tokyo
        };
        
        // Declaracion - Inicializacion de variables
        int menorTemperatura = temperaturas[0][0];
        int mayorTemperatura = temperaturas[0][1];
        String menorCiudad = ciudades[0];
        String mayorCiudad = ciudades[0];

        // Al tener la primera ciudad asignada me permite inicializar el for en la posicion 1.
        for (int i = 1; i < temperaturas.length; i++){
            int minimaTemperatura = temperaturas[i][0];
            int maximaTemperatura = temperaturas[i][1];

            if (minimaTemperatura < menorTemperatura) {
                menorTemperatura = minimaTemperatura;
                menorCiudad = ciudades[i];
            }

            if (maximaTemperatura > mayorTemperatura) {
                mayorTemperatura = maximaTemperatura;
                mayorCiudad = ciudades[i];
            }
        }

        System.out.println("La menor temperatura fue de " + menorTemperatura + "ºC en la Ciudad de " + menorCiudad);
        System.out.println("La mayor temperatura fue de " + mayorTemperatura + "ºC en la Ciudad de " + mayorCiudad);
    }
}