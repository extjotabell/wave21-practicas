package com.bootcamp.wave21;

public class Gato extends Animal implements Carnivoro{


    @Override
    public void emitirSonido() {
        System.out.println("MIAUUUUU");
    }


    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("YO SOY DE COMER PALOMAS");
    }
}
