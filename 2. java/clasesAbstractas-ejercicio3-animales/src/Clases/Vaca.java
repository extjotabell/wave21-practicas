package Clases;

import Interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    private String raza;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Vaca(String nombre, int edad, String raza){
        super(nombre, edad);
        this.raza = raza;

    }

    @Override
    public void emitirSonido(){
        System.out.println("MUUU");
    }

}
