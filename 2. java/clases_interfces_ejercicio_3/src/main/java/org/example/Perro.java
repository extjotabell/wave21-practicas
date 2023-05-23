package org.example;

public class Perro extends Animal implements Carnivoro {
    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Soy un perro y hago guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro y como carne");
    }
}
