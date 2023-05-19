import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Perecedero("Atun", 50, 2));
        productos.add(new Perecedero("Arroz", 80, 1));
        productos.add(new Perecedero("Azucar", 60, 3));
        productos.add(new NoPerecedero("Pollo", 150, "Carne"));
        productos.add(new NoPerecedero("Queso", 100, "Lacteos"));


        for(int i = 0; i < productos.size(); i++){
            System.out.println("Precio total del " + productos.get(i).nombre + ": " +productos.get(i).calcular(5));
        }



    }
}
