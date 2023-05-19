import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<Producto>();
        Producto pp1 = new Perecedero("Leche",2500,1);
        Producto pp2 = new Perecedero("Pan",400,1);
        Producto pp3 = new Perecedero("Yogurt",12000,15);
        Producto pp4 = new Perecedero("Tomate",500,3);
        Producto pp5 = new Perecedero("Manzana",1000,20);

        Producto pnp1 = new NoPerecedero("Arroz",2, "Tipo1");
        Producto pnp2 = new NoPerecedero("Fideos", 15, "Tipo2");
        Producto pnp3 = new NoPerecedero("Garbanzos", 30, "Tipo3");
        Producto pnp4 = new NoPerecedero("Lata de Atun", 25, "Tipo4");
        Producto pnp5 = new NoPerecedero("Avena", 35, "Tipo5");

        productos.add(pp1);
        productos.add(pp2);
        productos.add(pp3);
        productos.add(pp4);
        productos.add(pp5);


        productos.add(pnp1);
        productos.add(pnp2);
        productos.add(pnp3);
        productos.add(pnp4);
        productos.add(pnp5);

        double total = 0;

        //6260
        for (Producto producto : productos) {
            total += producto.calcular(5);
            System.out.println("total parcial -> " + total);
        }

        System.out.println("Precio total de los productos :" + total);



    }

}
