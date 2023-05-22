package com.bootcamp.wave21;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("GUAU GUAU");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("ME GUSTA EL DOGCHOW");
    }
}
