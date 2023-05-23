package com.bootcamp.wave21;


public class Main {

    public static void main(String[] args) {
        PDF pdf = new PDF();
        Persona juan = new  Persona("Juan","Martin",14,"BS AS");
        Curriculum cu = new Curriculum(juan);

        Impresora.imprimir(pdf);
        Impresora.imprimir(cu);
    }
}
