package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Perro doggy = new Perro();
        Gato kitty = new Gato();
        Vaca milky = new Vaca();

        doggy.emitirSonido();
        doggy.comerCarne();

        kitty.emitirSonido();
        kitty.comerCarne();

        milky.emitirSonido();
        milky.comerHierba();

        comerAnimal(doggy);
    }

    public static void comerAnimal(Animal animal){
        if (animal instanceof Perro)
            ((Perro) animal).comerCarne();
        else if (animal instanceof Gato)
            ((Gato) animal).comerCarne();
        else if (animal instanceof Vaca)
            ((Vaca) animal).comerHierba();
    }
}