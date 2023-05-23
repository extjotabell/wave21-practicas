package clases;

import interfaces.Carnivoro;
import interfaces.ComerAnimal;

public class Gato extends Animal implements Carnivoro, ComerAnimal {
    @Override
    protected void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public String toString() {
        return "Gato";
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comiendo "+animal.toString());
    }
}
