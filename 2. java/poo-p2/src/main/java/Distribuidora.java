import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> listaProductos = new LinkedList<>();
        Producto Platano = new Producto("Platano", 2500);
        Producto Pepsi = new Producto("Pepsi", 990);
        Producto Coca = new Producto("Coca Cola", 1250);
        Producto Fanta = new Producto("Fanta", 960);
        Producto Coliflor = new Producto("Coliflor", 450);

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
