package org.example.ejercicio2;


import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void imprimirDocumento(Documento doc) {
        doc.imprimir();
    }

    public static void main(String[] args) {

        List<String> habilidades = new ArrayList<>();
        habilidades.add("habilidad1");
        habilidades.add("habilidad2");
        habilidades.add("habilidad3");

        Documento cv = new Curriculum("Nombre", "Apellido", "Calle 123", 23, habilidades );

        Documento informe = new Informe("el texto  de un informe muy bien hecho",1,"jesucristo","Diosito");

        Documento libro = new LibrosPdf(100, "Sir Arthur Conan Doyle", "Sherlock Holmes", "Policial");

        imprimirDocumento(cv);
        imprimirDocumento(informe);
        imprimirDocumento(libro);

    }
}