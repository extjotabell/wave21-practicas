package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        List<Animal> animals = new ArrayList<>();
        animals.add(perro);
        animals.add(gato);
        animals.add(vaca);

        animals.forEach(animal -> {
            System.out.println(animal.emitirSonido());
        });

        //Extra
        animals.forEach(Main::comerAnimal);
    }

    private static void comerAnimal(Animal animal){

        if(animal instanceof Gato){
            Gato gato = (Gato) animal;
            System.out.println(gato.comerCarne());
        }else if (animal instanceof Perro){
            Perro perro = (Perro) animal;
            System.out.println(perro.comerCarne());
        }else if (animal instanceof Vaca){
            Vaca vaca = (Vaca) animal;
            System.out.println(vaca.comerHierba());
        }
    }
}
