public class Perro extends Animal implements Carnivoro,Alimentable{
    @Override
    public void emitirSonido() {
        System.out.println("guau guau");
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
