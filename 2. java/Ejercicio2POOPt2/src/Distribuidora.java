import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(new Perecedero(3, "Papa", 3000));
        productos.add(new NoPerecederos("3", "Leche", 4000));

        for(Producto producto : productos){
            System.out.println(producto.calcular(5));
        }

    }
}