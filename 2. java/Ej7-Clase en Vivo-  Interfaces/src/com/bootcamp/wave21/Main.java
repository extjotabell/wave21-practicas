package com.bootcamp.wave21;

public class Main {

    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.emitirSonido();
        perro.comer();
        gato.emitirSonido();
        gato.comer();
        vaca.emitirSonido();
        vaca.comer();
    }
}
