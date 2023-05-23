import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> listaProductos = new LinkedList<>();
        Producto Platano = new Perecedero("Platano", 2500, 2);
        Producto Pepsi = new Perecedero("Pepsi", 990, 5);
        Producto Coca = new NoPerecedero("Coca Cola", 1250, "NP");
        Producto Fanta = new NoPerecedero("Fanta", 960, "NP");
        Producto Coliflor = new Perecedero("Coliflor", 450, 3);

        listaProductos.add(0, Pepsi);
        listaProductos.add(1, Platano);
        listaProductos.add(2, Coca);
        listaProductos.add(3, Fanta);
        listaProductos.add(4, Coliflor);

        for( Producto producto: listaProductos){
            System.out.println("Al vender 5 productos de " + producto.nombre + " se obtiene: " + producto.calcular(5));
        }
    }
}
