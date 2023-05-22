package com.bootcamp.wave21;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;

/**
 * Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
 * imprimir el precio total al vender 5 productos de cada tipo.
 * Crear los elementos del array con los datos que quieras.
 */
public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();
        Producto leche = new Percedero(3,"leche entera", 1000);
        Producto yogurt = new Percedero(2,"Milkaut", 600);
        Producto yerbaAmanda = new NoPercedero("Yerba Amanda", 1000,"Almacen");
        Producto pepasFirulin = new NoPercedero("Pepas Firulin", 600,"Galles");
        Producto crema = new Percedero(1,"Crema para batir", 800);
        productos.add(leche);
        productos.add(yogurt);
        productos.add(yerbaAmanda);
        productos.add(pepasFirulin);
        productos.add(crema);
        System.out.println("PRECIOS POR PRODUCTO");
        for(Producto producto : productos){
            System.out.println("DATOS DEL PRODUCTO");
            System.out.println(producto.toString());
            System.out.println("EL total para la compra de 5 productos es: " + producto.cantidad(5));
        }
    }
}
