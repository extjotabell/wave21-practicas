// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Perro doggy = new Perro();
        Gato kitty = new Gato();
        Vaca milky = new Vaca();

        doggy.emitirSonido();
        doggy.comerCarne();

        kitty.emitirSonido();
        kitty.comerCarne();

        milky.emitirSonido();
        milky.comerHierba();

        Carnivoro.comer(doggy);
    }
}