public class Perro extends Animal implements Carnivoro {

    @Override
    protected void emitirSonido() {
        System.out.println("Guau...");
    }

    @Override
    public void comerCarne() {
        System.out.println("Perro: Estoy comiendo carne...");
    }
}
