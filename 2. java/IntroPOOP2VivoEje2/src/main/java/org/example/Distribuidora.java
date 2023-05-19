package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Perecedero> productosPer = new ArrayList<Perecedero>();
        List<NoPerecedero> productosNoPer = new ArrayList<NoPerecedero>();
        double precioTotal = 0;
        //Cargar productos Perecederos
        productosPer.add(new Perecedero(1,"Manzana", 3000));
        productosPer.add(new Perecedero(2,"Leche", 4000));
        productosPer.add(new Perecedero(3,"Carne", 12000));
        //Cargar Producto No Perecederos
        productosNoPer.add(new NoPerecedero("Grano","Sal", 2000));
        productosNoPer.add(new NoPerecedero("Enlatado","Atun", 15000));
        productosNoPer.add(new NoPerecedero("Grano","Arroz", 1500));


        for (Perecedero productoPer:productosPer)
        {
                precioTotal += productoPer.calcular(5);
        }

        for (NoPerecedero productoNoPer:productosNoPer)
        {
            precioTotal += productoNoPer.calcular(5);
        }

        System.out.println("El precio tatal de la venta es: "+ precioTotal);

    }
}