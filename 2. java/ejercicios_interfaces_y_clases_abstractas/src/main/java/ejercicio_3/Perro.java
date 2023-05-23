package ejercicio_3;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void EmitirSonido() {
        System.out.println("Wuf");
    }

    @Override
    public String toString() {
        return "Perro";
    }
}
