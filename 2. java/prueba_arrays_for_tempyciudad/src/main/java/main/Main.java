package main;

public class Main {
    //Resolviendo el ejercicio utilizando Burbujeo
    public static void main(String[] args) {
        // Declaración e inicialización del vector ciudades
        String ciudad[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa","Tokio"};

        // Declaración e inicialización de la matriz de temperaturas
        int temp[][]= {
                { -2, 33 },
                { -3, 32 },
                { -8, 27 },
                { 4, 37 },
                { 6, 42 },
                { 5, 43 },
                { 0, 39 },
                { -7, 26 },
                { -1, 32 },
                { -10, 35 }
        };


        // Obtener la longitud total de la matriz
        int longTotal = temp.length * temp[0].length;


        // Declarar un arreglo para la temperatura total y otro para ciudadades
        int[] tempTotal = new int[longTotal];
        String[] ciudadTotal = new String[longTotal];

        // Declaro un valor para poder tener la posición actual del bucle
        int posiActual = 0;

        // Copiar elementos de la matriz al arreglo
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                tempTotal[posiActual] = temp[i][j];
                posiActual++;
            }
        }


        // hago un bucle for utilizando la cantidad de posiciones que tiene el array de temp y guardo las ciudades duplicando la cantidad, asi coinciden.
        for (int i = 0; i < tempTotal.length; i++) {
            ciudadTotal[i] = ciudad[i / 2];
        }

        int len = tempTotal.length; // Longitud de la matriz temp

        // Ordeno el array de menor a mayor
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (tempTotal[j] > tempTotal[j + 1]) {
                    // Intercambio los elementos de temperatura
                    int ordenTemp = tempTotal[j];
                    tempTotal[j] = tempTotal[j + 1];
                    tempTotal[j + 1] = ordenTemp;

                    // Intercambio los elementos de ciudades
                    String ordenCiudad = ciudadTotal[j];
                    ciudadTotal[j] = ciudadTotal[j + 1];
                    ciudadTotal[j + 1] = ordenCiudad;

                }
            }
        }


        // Imprime la temperatura mínima y su ciudad utilizando la posición del array
        System.out.println("La temperatura menor la tuvo: " + ciudadTotal[0] +", con " + tempTotal[0] + " C");

        // Imprime la temperatura máxima y su ciudad utilizando la posición final del array
        System.out.println("La temperatura mayor la tuvo: " +  ciudadTotal[ciudadTotal.length - 1] + ", con " + tempTotal[tempTotal.length - 1] + " C");

    }
}
