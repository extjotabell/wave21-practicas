import Interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu");
    }

    @Override
    public String comerHierba() {
        return "Esta planta esta MUUUUUUUy buena";
    }
}
