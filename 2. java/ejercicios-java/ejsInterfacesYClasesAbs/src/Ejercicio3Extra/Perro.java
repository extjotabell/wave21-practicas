package Ejercicio3Extra;

public class Perro extends Animal implements ComenTodos {
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comer() {
        System.out.println("El perro esta comiendo carne.");
    }
}
