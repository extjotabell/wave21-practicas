package org.example.Animal;

import org.example.Alimentacion.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    public Vaca() {
        this.onomatopeya = "Muuuu";
    }

    @Override
    public void comerHierba() {

    }
}
