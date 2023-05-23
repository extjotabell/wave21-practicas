import Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guauuu");
    }

    @Override
    public String comerCarne() {
        return "Soy un Perro Carnivoro";
    }
}
