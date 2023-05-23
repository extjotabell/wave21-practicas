package org.example.Animal;

import org.example.Alimentacion.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    public Gato() {
        this.onomatopeya = "Miauuu";
    }

    @Override
    public void comerCarne() {

    }

    @Override
    public void comerAnimar(Animal presa) {

    }

}
