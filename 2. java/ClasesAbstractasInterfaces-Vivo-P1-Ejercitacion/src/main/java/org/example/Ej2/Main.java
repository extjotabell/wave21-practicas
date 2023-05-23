package org.example.Ej2;

/*Representar un escenario donde se creen cada uno de estos objetos y que,
por medio de un método estático de una interfaz imprimible,
se pueda pasar cualquier tipo de documento y sea impreso el contenido. */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona("Ana", "Perez", 25, 123445);
        List habilidades = new ArrayList();
        Informe informe1 = new Informe("Lorem Ipsum", 54,"Perez", "Gonzalez");
        LibroPdf libroPdf1 = new LibroPdf(40, "Java 1.1", "Fernandez", "terror");
        Curriculum curriculum1 = new Curriculum(persona1, habilidades);

        Impresora.imprimir(informe1);
        Impresora.imprimir(libroPdf1);
        Impresora.imprimir(curriculum1);
    }
}