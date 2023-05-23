package ejercicio_animales;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Animal> animales = new ArrayList<>();
        animales.add(new Perro());
        animales.add(new Vaca());
        animales.add(new Gato());

        for (Animal animal:animales) {
            animal.emitirSonido();
            animal.comer();
            System.out.println("-----------------");

        }
    }
}
