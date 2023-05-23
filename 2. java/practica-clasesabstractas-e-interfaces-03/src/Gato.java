public class Gato extends Animal implements Carnivoro,Alimentable{
    @Override
    public void emitirSonido() {
        System.out.println("miau miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
