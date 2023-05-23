package org.example;

public class Gato extends Animal implements Carnivoro {
    public Gato() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Soy un gato y hago miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gato y como carne");
    }
}
