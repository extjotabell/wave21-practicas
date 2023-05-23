package ejercicio3;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonido();
        gato.comerCarne();

        perro.emitirSonido();
        perro.comerCarne();

        vaca.emitirSonido();
        vaca.comerHierba();
        }
    }