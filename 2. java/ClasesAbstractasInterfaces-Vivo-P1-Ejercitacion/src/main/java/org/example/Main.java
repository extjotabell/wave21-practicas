package org.example;

/*Representar un escenario donde se creen cada uno de estos objetos y que,
por medio de un método estático de una interfaz imprimible,
se pueda pasar cualquier tipo de documento y sea impreso el contenido. */

import org.example.Ej2.*;
import org.example.Ej3.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Ejercicio 1-----------");


        System.out.println("-----------Ejercicio 2-----------");
        Persona persona1 = new Persona("Ana", "Perez", 25, 123445);
        List habilidades = new ArrayList<>();
        habilidades.add("Responsable");
        habilidades.add("Inteligente");
        habilidades.add("Puntual");
        habilidades.add("Sociable");
        Informe informe1 = new Informe("Lorem Ipsum", 54,"Perez", "Gonzalez");
        LibroPdf libroPdf1 = new LibroPdf(40, "Java 1.1", "Fernandez", "terror");
        Curriculum curriculum1 = new Curriculum(persona1, habilidades);

        Impresora.imprimir(informe1);
        Impresora.imprimir(libroPdf1);
        Impresora.imprimir(curriculum1);

        System.out.println("-----------Ejercicio 3-----------");

        Animal gato1 = new Gato("Pelusa");
        Animal perro1= new Perro("Toby");
        Animal vaca1= new Vaca("Bovi");

        System.out.println("Animales comiendo mediante comerAnimal");
        gato1.emitirSonido();
        comerAnimal(gato1);
        perro1.emitirSonido();
        comerAnimal(perro1);
        vaca1.emitirSonido();
        comerAnimal(vaca1);

        Gato gato2 = new Gato("Bola de nieves");
        Perro perro2= new Perro("Ayudante de Santa");
        Vaca vaca2= new Vaca("La serenisima");
        System.out.println("Animales comiendo mediante comerCarne/comerHierbas");
        gato2.emitirSonido();
        System.out.println(gato2.comerCarne());
        perro2.emitirSonido();
        System.out.println(perro2.comerCarne());
        vaca2.emitirSonido();
        System.out.println(vaca2.comerHierba());

    }
    public static void comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            System.out.println(((Gato) animal).comerCarne());
        } else if (animal instanceof Perro) {
            System.out.println(((Perro) animal).comerCarne());
        } else if (animal instanceof Vaca) {
            System.out.println( ((Vaca) animal).comerHierba());
        }
    }
}