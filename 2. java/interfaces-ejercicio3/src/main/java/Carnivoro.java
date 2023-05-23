public interface Carnivoro {
    void comerCarne();

    static void comerAnimal(Carnivoro animal){
        animal.comerCarne();
    }
}
