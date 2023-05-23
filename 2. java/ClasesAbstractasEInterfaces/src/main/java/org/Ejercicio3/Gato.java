package org.Ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Soy un Gato Y emito el sonido --> Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }
}
