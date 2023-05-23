package ejercicio3;

public class Perro extends Animal implements AlimentacionCarnivora{
    @Override
    protected String emitirSonido() {
        return "guau";
    }

    @Override
    public String comerCarne() {
        return "El perro come carne";
    }
}
