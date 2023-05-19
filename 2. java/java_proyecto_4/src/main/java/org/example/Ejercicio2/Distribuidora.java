package org.example.Ejercicio2;


import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        Producto noperecedero1 = new NoPerecedero("Arbejas", 10, "Enlatado");
        Producto noperecedero2 = new NoPerecedero("Atun", 10, "Enlatado");
        Producto noperecedero3 = new NoPerecedero("Miel", 10, "Artesanal");

        Producto perecedero1 = new Perecedero("Carne", 10, 5);
        Producto perecedero2 = new Perecedero("Leche", 10, 3);

        ArrayList<Producto> listaProductos = new ArrayList<>() {{
            add(noperecedero1);
            add(noperecedero2);
            add(noperecedero3);
            add(perecedero1);
            add(perecedero2);
        }};

        double ganancia = 0;
        for (Producto producto : listaProductos) {
            ganancia += producto.calcular(1);
        }

        System.out.println(ganancia);

    }
}