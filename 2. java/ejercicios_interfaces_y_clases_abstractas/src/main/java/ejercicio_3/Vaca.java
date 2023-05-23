package ejercicio_3;

public class Vaca extends Animal implements Herbivoro{
    @Override
    public void EmitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public String toString() {
        return "Vaca";
    }
}
