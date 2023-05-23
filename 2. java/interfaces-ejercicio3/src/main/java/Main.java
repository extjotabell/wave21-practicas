public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
        Carnivoro.comerAnimal(perro);

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
        Carnivoro.comerAnimal(gato);

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerPasto();
        Herbivoro.comerPlanta(vaca);
    }
}
