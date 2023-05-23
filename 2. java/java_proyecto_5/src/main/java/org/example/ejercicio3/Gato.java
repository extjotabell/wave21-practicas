package org.example.ejercicio3;

import org.example.ejercicio3.asbtract.Animal;
import org.example.ejercicio3.asbtract.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Estoy comiendo carne miau");
    }
}
