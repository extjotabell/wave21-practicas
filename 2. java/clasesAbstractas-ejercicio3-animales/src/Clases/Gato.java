package Clases;

import Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Gato(String nombre, int edad, String color){
        super(nombre, edad);
        this.color = color;
    }


    @Override
    public void emitirSonido() {
        System.out.println("MIAU");
    }

}
