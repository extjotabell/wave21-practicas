package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        sumatoria();
//        promedio();
//        filtro();
//        ordenar();
        map();
    }

    public static void sumatoria(){
        System.out.println("SUMATORIA");
        int suma;
        /* Bucles */
        suma = 0;
        List<Integer> numbers = Arrays.asList(25, 75, 100, 290, 10);

/*        for(int n: numbers){
            suma += n;
        }*/

        /* Lambdas */
        suma = numbers.stream()
                .mapToInt(n -> n)
                .sum();

        System.out.println("Suma: " + suma);
    }

    public static void promedio(){
        System.out.println("PROMEDIO");
        int suma;
        double promedio;
        /* Bucles */
        suma = 0;
        List<Integer> numbers = Arrays.asList(25, 75, 100, 290, 10);
        //int[] numbers = {25, 75, 100, 290, 10};
        for(int n: numbers){
            suma += n;
        }
        promedio = (double) suma / numbers.size();

        /* Lambdas */
        promedio = numbers.stream()
                    .mapToInt(n -> n)
                    .average()
                    .orElse(0D);

        System.out.println("Promedio: " + promedio);
    }

    public static void filtro(){
        System.out.println("FILTRO");
        List<String> nombresL = Arrays.asList("Sofía", "Luis", "Martina","Sebastián", "Valentina",
                "Diego", "Isabella", "Carlos", "Camila", "Joaquín", "Ana");

        String[] nombres = {"Sofía", "Luis", "Martina","Sebastián", "Valentina",
                "Diego", "Isabella", "Carlos", "Camila", "Joaquín", "Ana"};
        String[] nombresFiltro = new String[4];
        /* Bucles */
        int iFiltro = 0;
        for (String nombre : nombres) {
            if (nombre.length() <= 5) {
                nombresFiltro[iFiltro] = nombre;
                iFiltro++;
            }
        }

        /* Lambdas */
        List<String> nombresF = nombresL.stream()
                                .filter( n -> n.length() <= 5)
                                .collect(Collectors.toList());

        System.out.println("Nombre filtro: " + nombresF);
        System.out.println("Nombre filtro: " + Arrays.toString(nombresFiltro));
    }

    public static void ordenar(){
        System.out.println("ORDENAR");
        List<String> nombresL = Arrays.asList("Sofía", "Luis", "Martina","Sebastián", "Valentina",
                "Diego", "Isabella", "Carlos", "Camila", "Joaquín", "Ana");
        String[] nombres = {"Sofía", "Luis", "Martina","Sebastián", "Valentina",
                "Diego", "Isabella", "Carlos", "Camila", "Joaquín", "Ana"};
        /* método sort */
        Arrays.sort(nombres);

        /* Lambdas */
        //Comparator<Persona> ordenarNombre = Comparator.comparing(Persona::getNombre).thenComparing(Persona::getEdad);
        Comparator<String> ordenarNombre = Comparator.naturalOrder();

        List<String> nombresS = nombresL.stream()
                                .sorted(ordenarNombre)
                                .collect(Collectors.toList());

        System.out.println("Nombres orden: " + nombresS);
        System.out.println("Nombre orden: " + Arrays.toString(nombres));
    }

    public static void map(){
        System.out.println("MAPEO");
        List<String> nombresL = Arrays.asList("Sofía", "Luis", "Martina","Sebastián", "Valentina",
                "Diego", "Isabella", "Carlos", "Camila", "Joaquín", "Ana");
        String[] nombres = {"Sofía", "Luis", "Martina","Sebastián", "Valentina",
                "Diego", "Isabella", "Carlos", "Camila", "Joaquín", "Ana"};
        int[] tamaniosNombres = new int[nombres.length];
        /* Bucles */
        for (int i = 0; i < nombres.length; i++) {
            tamaniosNombres[i] = nombres[i].length();
        }

        /* Lambdas */
        List<Integer> ns = nombresL.stream()
                            .map(String::length) /* n -> n.length() */
                            .toList();
        System.out.println("Tamaños nombres: " + ns);
        System.out.println("Tamaños nombres: " + Arrays.toString(tamaniosNombres));
    }
}