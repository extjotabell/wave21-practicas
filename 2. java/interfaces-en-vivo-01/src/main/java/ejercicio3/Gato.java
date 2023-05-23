package ejercicio3;

public class Gato extends Animal implements AlimentacionCarnivora{
    @Override
    protected String emitirSonido() {
        return "miau";
    }

    @Override
    public String comerCarne() {
        return "El gato come carne";
    }
}
