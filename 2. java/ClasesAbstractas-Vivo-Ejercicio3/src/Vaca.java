import Interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu");
    }

    @Override
    public String comerHierba() {
        return "Esta planta esta MUUUUUUUy buena";
    }
}
