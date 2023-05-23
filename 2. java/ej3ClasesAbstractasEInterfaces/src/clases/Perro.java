package clases;

import interfaces.Carnivoro;
import interfaces.ComerAnimal;

public class Perro extends Animal implements Carnivoro, ComerAnimal {

    @Override
    protected void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public String toString() {
        return "Perro";
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comiendo "+animal.toString());
    }
}
