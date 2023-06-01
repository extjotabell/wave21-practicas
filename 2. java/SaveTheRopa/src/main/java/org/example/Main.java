package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Crear en la clase Main un escenario en el cual alguien guarde dos prendas,
        // reciba el código y luego consulta por sus prendas guardadas.

        Prenda prenda1 = new Prenda("Zara", "remera");
        Prenda prenda2 = new Prenda("Zara", "sweater");
        List<Prenda> lista1 = new ArrayList<>();
        lista1.add(prenda1);
        lista1.add(prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();
        System.out.println(guardaRopa.guardarPrendas(lista1));
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(1));
    }
}