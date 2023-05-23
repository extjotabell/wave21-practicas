package org.Ejercicio3;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Soy un Perro Y emito el sonido --> Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }
}
