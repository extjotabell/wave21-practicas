package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Informe informe1 = new Informe("Esto es un texto", 10, "Gastón", "Matias");

        informe1.imprimir();

        LibroPDF libropdf1 = new LibroPDF(120, "Gastón", "La Bella", "Terror");

        libropdf1.imprimir();

        Curriculum curriculum1 = new Curriculum("Gastón", "Dominguez", 38, "Responsable");

        curriculum1.imprimir();
    }
}