package ejercicio3;

public class Vaca extends Animal implements Herbivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public String comerHierba() {
        return "Como mucha Hierba niam";
    }
}
