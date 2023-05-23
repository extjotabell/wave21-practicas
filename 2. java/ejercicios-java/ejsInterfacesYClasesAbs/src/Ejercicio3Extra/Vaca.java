package Ejercicio3Extra;

public class Vaca extends Animal implements ComenTodos {
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comer() {
        System.out.println("La vaca esta comiendo hierbas");
    }
}
