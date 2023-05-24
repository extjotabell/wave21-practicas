package Interfaces;

import Clases.Animal;

public interface Carnivoro {
    public static void comerCarne(Animal animal){
        System.out.println("------"+ Carnivoro.class.getSimpleName().toUpperCase() + "-----");
        System.out.println("Come Carne");
    }

}
