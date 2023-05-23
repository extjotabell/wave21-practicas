package clases;

import interfaces.ComerAnimal;
import interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro,ComerAnimal {
    @Override
    protected void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comiendo "+animal.toString());
    }

    @Override
    public String toString() {
        return "Vaca";
    }
}
