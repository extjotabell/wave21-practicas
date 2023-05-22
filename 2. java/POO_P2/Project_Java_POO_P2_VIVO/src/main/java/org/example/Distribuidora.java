package org.example;

import java.util.*;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> listaDeProductos = new ArrayList<>();

        Producto producto1 = new Perecedero("Harina", 100, 2);
        Producto producto2 = new NoPerecedero("Fideos", 1400, "1");
        Producto producto3 = new Perecedero("Atun", 570, 3);
        Producto producto4 = new NoPerecedero("Polenta", 340, "2");
        Producto producto5 = new Perecedero("Salta de Tomate", 250, 1);
        Producto producto6 = new NoPerecedero("Aceitunas", 300, "3");

        listaDeProductos.add(producto1);
        listaDeProductos.add(producto2);
        listaDeProductos.add(producto3);
        listaDeProductos.add(producto4);
        listaDeProductos.add(producto5);
        listaDeProductos.add(producto6);

        for (int i=0; i < listaDeProductos.size(); i++){
            System.out.println(listaDeProductos.get(i).calcular(5));
        }
    }
}
