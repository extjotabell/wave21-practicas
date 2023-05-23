package Ejercicio_3.interfaces;

import Ejercicio_3.clases.Animal;

public interface Carnivoro {
    public void comerCarne();
    default void comerAnimal(Animal animal){
        System.out.println(String.format("Se esta comiendo a %s...", animal.getNombre()));
    }
}
