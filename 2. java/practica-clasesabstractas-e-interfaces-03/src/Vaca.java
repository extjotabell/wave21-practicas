public class Vaca extends Animal implements  Herviboro,Alimentable{
    @Override
    public void emitirSonido() {
        System.out.println("muuu muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pastito");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
