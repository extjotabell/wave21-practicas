package Interfaces;

import Clases.Animal;

public interface Herviboro {

    public static void comerHierva(Animal animal){
        System.out.println("------"+ Herviboro.class.getSimpleName().toUpperCase() + "-----");
        System.out.println("Come Carne");
    }
}
