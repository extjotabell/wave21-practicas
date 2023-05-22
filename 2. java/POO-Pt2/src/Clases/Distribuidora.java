package Clases;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList();
        double precioTotal = 0;

        // No Perecederos
        Producto p1 = new NoPerecedero(20, "Auriculares", "Electronica");
        productos.add(p1);
        Producto p2 = new NoPerecedero(30, "teclado", "Electronica");
        productos.add(p2);
        Producto p3 = new NoPerecedero(45, "Mousepad", "Electronica");
        productos.add(p3);
        Producto p4 = new NoPerecedero(160, "macPro", "Electronica");
        productos.add(p4);
        Producto p5 = new NoPerecedero(130, "mouse", "Electronica");
        productos.add(p5);


        // Perecederos
        Producto p6 = new Perecedero(300, "queso", 2);
        productos.add(p6);
        Producto p7 = new Perecedero(300, "jamon", 1);
        productos.add(p7);
        Producto p8 = new Perecedero(280, "papas", 4);
        productos.add(p8);
        Producto p9 = new Perecedero(290, "yogur", 3);
        productos.add(p9);
        Producto p10 = new Perecedero(90, "Mani", 3);
        productos.add(p10);

        for(Producto p: productos){
            precioTotal = p.calcular((int)Math.floor((Math.random() * 100) + 1));
        }
        System.out.println("El Precio total es de: " + precioTotal);
    }
}
