package Ejercicio3Extra;

public class Main {
    public static void main(String[] args) {
        Perro doggy = new Perro();
        Gato kitty = new Gato();
        Vaca milky = new Vaca();

        doggy.emitirSonido();
        ComenTodos.comerAnimal(doggy);

        kitty.emitirSonido();
        ComenTodos.comerAnimal(kitty);

        milky.emitirSonido();
        ComenTodos.comerAnimal(milky);
    }
}