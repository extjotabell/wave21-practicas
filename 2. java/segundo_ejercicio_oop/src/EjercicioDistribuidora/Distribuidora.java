package EjercicioDistribuidora;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        Producto productoBase = new Producto("Producto base", 23.99);
        Producto productoPerecedero = new Perecedero("Producto Perecedero", 49.99, 2);
        Producto productoNoPerecedero = new NoPerecedero("Producto no perecedero", 10,"Un tipo");

        List<Producto> productos = new ArrayList<>();
        productos.add(productoBase);
        productos.add(productoPerecedero);
        productos.add(productoNoPerecedero);

        int cantidadProductosAComprar = 5;
        for (Producto p : productos) {
            System.out.println("Comprando el siguiente producto: " + p.toString());
            System.out.printf("%s%.2f%n","El precio total de la compra es: ", p.calcular(cantidadProductosAComprar));
        }
    }
}
