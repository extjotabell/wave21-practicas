package com.bootcamp.wave21;

public abstract class Animal {

    public abstract void emitirSonido();
    public abstract void comer();

    public static void comerAnimal(Animal animal){
        animal.comer();
    }
}
