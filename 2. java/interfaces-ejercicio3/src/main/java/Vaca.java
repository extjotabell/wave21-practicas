public class Vaca extends Animal implements Herbivoro{

    @Override
    protected void emitirSonido() {
        System.out.println("Muu...");
    }

    @Override
    public void comerPasto() {
        System.out.println("Vaca: Estoy comiendo pasto que riiico T_T....");
    }
}
