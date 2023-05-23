package Ejercicio_3.clases;

import Ejercicio_3.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau!");
    }

    @Override
    public void comerCarne() {

    }

}
