import Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miauuu");
    }

    @Override
    public String comerCarne() {
        return "Soy un Gato Carnivoro";
    }
}
