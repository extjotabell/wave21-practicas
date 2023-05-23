package ejercicio_3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void EmitirSonido() {
        System.out.println("Miauu");
    }

    @Override
    public String toString() {
        return "Gato";
    }
}
