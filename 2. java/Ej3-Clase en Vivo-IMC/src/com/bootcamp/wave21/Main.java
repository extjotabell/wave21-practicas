package com.bootcamp.wave21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args){
    Persona juanma = new Persona();
    Persona matias = new Persona("Matias",34,"33366655");
    Persona guille = new Persona("Guille",15,"33344499",75,1.73);
    int valorIMCGuille;
    FileInputStream fis ;
    valorIMCGuille = guille.calcularIMC();
    System.out.println("VAMOS A CALCULAR EL IMC DE " + guille.nombre);
    System.out.println("DATOS GENERALES");
    System.out.println(guille.toString());

    switch (valorIMCGuille) {
        case -1:
            System.out.println("ESTAS CON BAJO PESO");
            break;
        case  0:
            System.out.println("ESTAS CON PESO SALUDABLE");
            break;
        case  1:
            System.out.println("ESTAS CON SOBRE PESO");
    }

}
