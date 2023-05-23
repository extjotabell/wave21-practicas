package org.example.Animal;

import org.example.Alimentacion.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    public Perro() {
        this.onomatopeya = "Guauuu";
    }

    @Override
    public void comerCarne() {

    }

    @Override
    public void comerAnimar(Animal presa) {



    }
}
