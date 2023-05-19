package POO_P2_ej2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();

        productos.add(new Perecedero("pan", 200, 1));
        productos.add(new Perecedero("queso", 500, 3));
        productos.add(new Perecedero("fiambre", 300, 2));
        productos.add(new NoPerecedero("pelota", 150, "deportes"));
        productos.add(new NoPerecedero("pincel", 150, "arte"));
        double total = 0;
        int [] cantidades = {2,1,1,2,3};
        System.out.println("Estos son los productos existentes: ");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).calcular(cantidades[i]);
            System.out.println(productos.get(i).toString() + ". Unidades " + cantidades[i]);
        }
        System.out.println("-------------------------------------------");
        System.out.println("El precio total es: " + total);

    }
}
