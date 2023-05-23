package org.example;

public class Vaca extends Animal implements Herviboro {
    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Soy una vaca y hago muuu");
    }

    @Override
    public void comerHierva() {
        System.out.println("Soy un vaca y como hiervas");
    }
}
