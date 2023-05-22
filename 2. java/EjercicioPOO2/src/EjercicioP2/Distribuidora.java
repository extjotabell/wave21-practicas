package EjercicioP2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        //Creamos la lista de productos
        List<Producto> productos = new ArrayList<Producto>(5);

        //Creo los productos precederos
        Perecederos productoPerecedero1 = new Perecederos("Perecedero1",35.50,15);
        Perecederos productoPerecedero2 = new Perecederos("Perecedero2",40.33,30);
        Perecederos productoPerecedero3 = new Perecederos("Perecedero3",150,45);
        Perecederos productoPerecedero4 = new Perecederos("Perecedero4",113.68,90);
        Perecederos productoPerecedero5 = new Perecederos("Perecedero5",22.99,3);

        //Seteo los precios de los prodcutos según los dias que hayan caducado
        //productoPerecedero1.

        //Cre los productos no precederos
        NoPerecedero productoNoPerecedero1 = new NoPerecedero("NoPerecedero1",134,"Legumbre");
        NoPerecedero productoNoPerecedero2 = new NoPerecedero("NoPerecedero2",100,"Fideo");
        NoPerecedero productoNoPerecedero3 = new NoPerecedero("NoPerecedero3",92.45,"Arroz");
        NoPerecedero productoNoPerecedero4 = new NoPerecedero("NoPerecedero4",42.5,"Legumbre");
        NoPerecedero productoNoPerecedero5 = new NoPerecedero("NoPerecedero5",39.99,"Arroz");

        //Agrego a la lista los productos perecederos
        productos.add(productoPerecedero1);
        productos.add(productoPerecedero2);
        productos.add(productoPerecedero3);
        productos.add(productoPerecedero4);
        productos.add(productoPerecedero5);

        //Agrego a la lista los productos no perecederos
        productos.add(productoNoPerecedero1);
        productos.add(productoNoPerecedero2);
        productos.add(productoNoPerecedero3);
        productos.add(productoNoPerecedero4);
        productos.add(productoNoPerecedero5);

        //Forma mejor y directa de agregar objetos a una lista
        productos.add(new Perecederos("ProductoNoPerecedero",25,99));

        //System.out.println(productos);


        //De todo mi array de productos los voy imprimiendo con su total de 5 y luego pongo el valor final
        double totalProductos = 0;
        System.out.println("-------------------------------------------------------------");
        System.out.println("Comienza el armado de la lista de precios");
        for (int i=0;i<productos.size();i++){
            System.out.println("Los 5 productos de "+ productos.get(i).getNombre() + " valen un total de: "+ productos.get(i).calcular(5));
            totalProductos = totalProductos + productos.get(i).calcular(5);

        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("El total de la venta es de: " + totalProductos);

    }

}
