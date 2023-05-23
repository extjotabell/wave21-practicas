package ejercicio_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();


        List<Animal> animales = new ArrayList<>();
        animales.add(vaca);
        animales.add(perro);
        animales.add(gato);

        System.out.println("Emitir sonidos");
        for (Animal animal : animales) {
            animal.EmitirSonido();
        }
        System.out.println("Alimentar animales");
        vaca.comerHierba();
        perro.comerCarne();
        gato.comerCarne();

        System.out.println("Comiendo otros animales, solo carnivoros");
        gato.comerOtro(vaca);
        perro.comerOtro(perro);
    }
}
