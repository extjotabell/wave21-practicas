public class Gato extends Animal implements Carnivoro {

    @Override
    protected void emitirSonido() {
        System.out.println("Miau...");
    }

    @Override
    public void comerCarne() {
        System.out.println("Gato: Estoy comiendo salmón y ratones...");
    }
}
