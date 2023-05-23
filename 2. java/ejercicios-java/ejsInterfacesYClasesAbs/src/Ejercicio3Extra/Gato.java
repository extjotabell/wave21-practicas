package Ejercicio3Extra;

public class Gato extends Animal implements ComenTodos {
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comer() {
        System.out.println("El gato esta comiendo carne.");
    }
}
