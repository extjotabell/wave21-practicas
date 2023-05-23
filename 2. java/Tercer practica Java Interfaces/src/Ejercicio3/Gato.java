package Ejercicio3;

public class Gato extends Animal{

    @Override
    public String emitirSonido() {
        return "Miauuu";
    }

    @Override
    public String comer() {
        return "Tiene una alimentacion carnivora";
    }
}
