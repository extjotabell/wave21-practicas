package Ejercicio3;

public class Vaca extends Animal{
    @Override
    public String emitirSonido() {
        return "Muuuu";
    }

    @Override
    public String comer() {
        return "Tiene una alimentacion herbivora";
    }
}
