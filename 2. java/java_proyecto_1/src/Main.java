public class Main {
    public static void main(String[] args) {
//        Definimos el array de ciudades
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio"};

//        Definimos el array de temperaturas
        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 25}
        };

//        Asignamos los primeros valores como los finales, para despues comparar si alguno lo supera
        int temp_minima = temperaturas[0][0];
        int temp_maxima = temperaturas[0][1];
        String ciudad_minima = ciudades[0];
        String ciudad_maxima = ciudades[0];

//        Recorremos el array de temperaturos, comparamos y asignamos
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temp_minima) {
                temp_minima = temperaturas[i][0];
                ciudad_minima = ciudades[i];
            }
            if (temperaturas[i][1] > temp_maxima) {
                temp_maxima = temperaturas[i][1];
                ciudad_maxima = ciudades[i];
            }
        }

        System.out.println("Frio maximo: " + ciudad_minima + " - " + temp_minima);
        System.out.println("Calor maximo: " + ciudad_maxima + " - " + temp_maxima);
    }
}
