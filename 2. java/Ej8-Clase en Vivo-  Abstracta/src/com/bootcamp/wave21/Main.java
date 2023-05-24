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
        System.out.println("AHORA CON EL METODO DE LA CLASE ");
        Animal.comerAnimal(perro);
        Animal.comerAnimal(gato);
        Animal.comerAnimal(vaca);
    }
}
