package ejercicio3;

public class Vaca extends Animal implements AlimentacionHerbivora{
    @Override
    protected String emitirSonido() {
        return "muuu";
    }

    @Override
    public String comerHierba() {
        return "La vaca come hierba";
    }
}
