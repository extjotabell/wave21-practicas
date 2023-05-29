package ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public String comerCarne() {
        return "Como mucha carne niam";
    }
}
