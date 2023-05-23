package org.example.ejercicio3;

import org.example.ejercicio3.asbtract.Animal;
import org.example.ejercicio3.asbtract.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Estoy comiendo pasto muuu");
    }
}
