public interface Carnivoro {
    public void comerCarne();

    public static void comer(Carnivoro car){
        car.comerCarne();
    }
}
