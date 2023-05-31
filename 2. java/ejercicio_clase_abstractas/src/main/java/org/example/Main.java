package org.example;

public class Main {
    public static void main(String[] args) {
        IntegerSeries twoSeries = new IntegerSeries(2);
        System.out.println(twoSeries.getNext());  // Imprime 2
        System.out.println(twoSeries.getNext());  // Imprime 4
        System.out.println(twoSeries.getNext());  // Imprime 6
        System.out.println(twoSeries.getNext());  // Imprime 8

        twoSeries.setInitial(1);
        System.out.println(twoSeries.getNext());  // Imprime 3
        System.out.println(twoSeries.getNext());  // Imprime 5
        System.out.println(twoSeries.getNext());  // Imprime 7
        System.out.println(twoSeries.getNext());  // Imprime 9

        IntegerSeries threeSeries = new IntegerSeries(3);
        System.out.println(threeSeries.getNext());  // Imprime 3
        System.out.println(threeSeries.getNext());  // Imprime 6
        System.out.println(threeSeries.getNext());  // Imprime 9
        System.out.println(threeSeries.getNext());  // Imprime 12
    }
}