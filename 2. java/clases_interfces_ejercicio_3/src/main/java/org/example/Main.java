package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Perro perro1 = new Perro();
        Gato gato1 = new Gato();
        Vaca vaca1 = new Vaca();

        perro1.emitirSonido();
        perro1.comerCarne();
        gato1.emitirSonido();
        gato1.comerCarne();
        vaca1.emitirSonido();
        vaca1.comerHierva();


    }
}