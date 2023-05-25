package org.example;

import java.util.Arrays;

//Se plantea crear una clase con un método static llamado burbuja,
// que recibe un arreglo de enteros primitivos int[]
// y devuelve el arreglo, ordenado de forma ascendente.
public class Burbuja {
    public static int[] burbuja(int[] array) {
        int a, b, aux;
        for (a =0 ; a<array.length-1; a++){
            for (b = 0; b < array.length - a - 1; b++) {
                if (array[b + 1] < array[b]) {
                    aux = array[b + 1];
                    array[b + 1] = array[b];
                    array[b] = aux;
                }
            }
        }
        return array;
    }


    public static int[] burbuja2(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
