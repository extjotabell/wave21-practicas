package Ejercicio3;

public class Perro extends Animal{
    @Override
    public String emitirSonido() {
        return "Guau";
    }

    @Override
    public String comer() {
        return "Tiene una alimentacion carnivora";
    }
}
