public class Vaca extends Animal implements Herbivoro{
    @Override
    public void emitirSonido() {
        System.out.println("muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Como hierba");
    }
}
