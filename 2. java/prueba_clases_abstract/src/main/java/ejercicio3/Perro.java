package ejercicio3;

public class Perro extends Animal implements Carnivoro{


    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public String comerCarne() {
        return "Como mucha carne niam";
    }
}
