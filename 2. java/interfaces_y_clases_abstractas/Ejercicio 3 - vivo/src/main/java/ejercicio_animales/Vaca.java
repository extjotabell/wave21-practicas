package ejercicio_animales;

public class Vaca extends Animal implements Herbivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }
    @Override
    public void comer() {
        comerHierba();
    }
}
