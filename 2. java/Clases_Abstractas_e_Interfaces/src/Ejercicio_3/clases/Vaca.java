package Ejercicio_3.clases;

import Ejercicio_3.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu!");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo Hierba...");
    }
}
