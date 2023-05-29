package Ejercicio_abstract_Part1;

public class Main {
    public static void main(String[] args) {
        Hija1<Integer> serie1 = new Hija1<>(2);
        serie1.initSerie(2);

        System.out.println("-------------PARTE 1---------------");
        System.out.println(serie1.nextSerie());
        System.out.println(serie1.nextSerie());
        System.out.println(serie1.nextSerie());
        System.out.println(serie1.nextSerie());



        Hija1<Integer> serie2 = new Hija1<>(2);
        serie2.initSerie(1);
        System.out.println("-------------PARTE 2---------------");
        System.out.println(serie2.nextSerie());
        System.out.println(serie2.nextSerie());
        System.out.println(serie2.nextSerie());
        System.out.println(serie2.nextSerie());


        Hija1<Integer> serie3 = new Hija1<>(3);
        serie3.initSerie(3);
        System.out.println("-------------PARTE 3---------------");
        System.out.println(serie3.nextSerie());
        System.out.println(serie3.nextSerie());
        System.out.println(serie3.nextSerie());
        System.out.println(serie3.nextSerie());

        Hija2<Integer> serie4 = new Hija2<>(2);
        serie4.initSerie(2);
        System.out.println("-------------EXPERIMENTANDO PARTE 4---------------");
        System.out.println(serie4.nextSerie());
        System.out.println(serie4.nextSerie());
        System.out.println(serie4.nextSerie());
        System.out.println(serie4.nextSerie());


    }
}
