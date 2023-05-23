package org.Ejercicio3;

public class Vaca extends Animal implements Herbivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Soy una Vaca Y emito el sonido --> Muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Como hierba");
    }
}
