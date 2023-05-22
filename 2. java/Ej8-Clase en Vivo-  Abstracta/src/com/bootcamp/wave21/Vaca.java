package com.bootcamp.wave21;

public class Vaca extends Animal implements Herviboro{

    @Override
    public void emitirSonido() {
        System.out.println("MUUUUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("ME GUSTA EL PASTO CON PURE");
    }


    @Override
    public void comer() {
        this.comerHierba();
    }
}
