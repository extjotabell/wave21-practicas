package org.example.ejercicio3;

import org.example.ejercicio3.asbtract.Animal;
import org.example.ejercicio3.asbtract.Carnivoro;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

//        Sonido
        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

//        Comer
//        gato.comerCarne();
//        perro.comerCarne();
//        vaca.comerHierba();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);

    }

//    Comer animal
    public static void comerAnimal(Animal animal){
        if(animal instanceof Perro || animal instanceof Gato){
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            ((Vaca) animal).comerHierba();
        }
    }
}