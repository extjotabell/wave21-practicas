package ej_temperaturas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int tamanio = 0;
        String[] paises;
        int[][] temperatura;

        System.out.println("Bienvenido! Si desea cargar los valore a mano presione s");
        String rta = teclado.next();

        if(rta.equals("s") || rta.equals("S")){
            while (tamanio <= 0){
                System.out.println("Cuantos paises desea cargar? Recuerde que debe ser al menos 1");
                tamanio = teclado.nextInt();
                teclado.nextLine();
            }
            paises = new String[tamanio];
            temperatura = new int[tamanio][2];

            obtener_datos(teclado, paises, temperatura);
        }else{
            paises = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo",
                    "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
            temperatura = new int[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        }

        int pos_minimo = calcular_minimo(temperatura);
        int pos_maximo = calcular_maximo(temperatura);
        mostrar_resultados(paises,temperatura, pos_minimo, pos_maximo);
    }

    private static void obtener_datos(Scanner teclado, String[] paises, int[][] temperatura) {
        for(int i = 0; i < paises.length; i++){
            System.out.println("Ingrese el nombre del pais para la posicion " + (i + 1));
            paises[i] = teclado.nextLine();
            System.out.println("Ingrese la temperatura minima para " + paises[i]);
            temperatura[i][0] = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Ingrese la temperatura maxima para " + paises[i]);
            temperatura[i][1] = teclado.nextInt();
            teclado.nextLine();
        }
    }

    private static void mostrar_resultados(String[] paises, int[][] temperatura, int pos_minimo, int pos_maximo) {
        System.out.println("El pais con mayor temperatura fue " + paises[pos_maximo] + " con: " + temperatura[pos_maximo][1] + "ºC");
        System.out.println("El pais con menor temperatura fue " + paises[pos_minimo] + " con: " + temperatura[pos_minimo][0] + "ºC");

    }

    private static int calcular_maximo(int[][] temperatura) {
        int max = -100;
        int pos_max = 0;
        for(int i = 0; i < temperatura.length; i++){
            if(temperatura[i][1] > max){
                max = temperatura[i][1];
                pos_max = i;
            }
        }
        return pos_max;
    }

    private static int calcular_minimo(int[][] temperatura) {
        int min = 100;
        int pos_min = 0;
        for(int i = 0; i < temperatura.length; i++){
            if(temperatura[i][0] < min){
                min = temperatura[i][0];
                pos_min = i;
            }
        }
        return pos_min;
    }

}



