import Clases.Animal;
import Clases.Gato;
import Clases.Perro;
import Clases.Vaca;
import Interfaces.Carnivoro;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Animal perro1 = new Perro("manchitas", 2, "Labrador");
        Animal perro2 = new Perro("Laica", 3, "Ovejero");
        Animal gato1 = new Gato("michifus", 3, "negro y blanco");
        Animal vaca1 = new Vaca("Lechona", 5, "Angus");

        Carnivoro.comerCarne(perro1);
        perro1.emitirSonido();

    }
}