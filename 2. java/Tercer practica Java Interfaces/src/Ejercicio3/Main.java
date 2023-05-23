package Ejercicio3;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        System.out.println("Es un perro: " + perro.comer() + ". " + perro.emitirSonido());
        System.out.println("Es un gato: " + gato.comer() + ". " + gato.emitirSonido());
        System.out.println("Es una vaca: " + vaca.comer() + ". " + vaca.emitirSonido());
    }
}
