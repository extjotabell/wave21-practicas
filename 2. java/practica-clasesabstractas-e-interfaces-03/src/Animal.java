public abstract class Animal {
    public abstract void emitirSonido();

    public static void comerAnimal(Alimentable alimentable){
        alimentable.comer();
    }
}
