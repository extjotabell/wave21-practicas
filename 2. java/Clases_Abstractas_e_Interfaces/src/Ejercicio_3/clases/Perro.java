package Ejercicio_3.clases;

import Ejercicio_3.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }

}
