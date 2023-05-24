package Clases;

import Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    private String raza;
    public Perro(String nombre, int edad, String raza){
        super(nombre, edad);
        this.raza = raza;
    }
    @Override
    public void emitirSonido() {
        System.out.println("GUAU");
    }


}
