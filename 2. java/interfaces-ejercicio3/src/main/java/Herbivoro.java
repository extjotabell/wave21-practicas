public interface Herbivoro {
    void comerPasto();

    static void comerPlanta(Herbivoro animal){
        animal.comerPasto();
    }
}
