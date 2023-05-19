package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    //Ejercicio 2
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Producto producto1 = new Perecedero("Atún",20D,2,1);
        productos.add(producto1);
        Producto producto2 = new NoPerecedero("Cepillo Dental",30D,2,"Higiene");
        productos.add(producto2);
        Producto producto3 = new Perecedero("Carne",40D,2,2);
        productos.add(producto3);
        Producto producto4 = new NoPerecedero("Muñeco",50D,2,"Juguete");
        productos.add(producto4);
        Producto producto5 = new Perecedero("Pollo",60D,2,3);
        productos.add(producto5);

        imprimirTotalLista(productos);
    }

    private static void imprimirTotalLista(List<Producto> productos){
        final double[] total = {0D};
        productos.forEach(producto ->{
            total[0] = total[0] + producto.calcular(producto.getCantidad());
        });
        System.out.println("El precio total es de: " + total[0] + " dolares");
    }
}
