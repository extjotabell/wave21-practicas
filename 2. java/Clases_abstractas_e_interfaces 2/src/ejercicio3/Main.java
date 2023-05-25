package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Animal> animales = new ArrayList<Animal>();

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        animales.add(perro);
        animales.add(gato);
        animales.add(vaca);

        for (Animal animal:animales) {
            imprimirAnimal(animal);
        }

    }

    public static void imprimirAnimal(Animal animal){
        animal.emitirSonido();
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }
        else if(animal instanceof Herbivoro){
            ((Herbivoro) animal).comerHierba();
        }
    }

}
