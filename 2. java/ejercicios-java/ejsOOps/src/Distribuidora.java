import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        Producto prod1 = new Producto("Milanesa", 200);
        Perecedero prod2 = new Perecedero("Pollo", 300, 4);
        Perecedero prod3 = new Perecedero("Carne", 400, 3);
        NoPerecedero prod4 = new NoPerecedero("Arroz", 100, "Comida");
        NoPerecedero prod5 = new NoPerecedero("Atun", 50, "Pescados");

        //System.out.println(prod4.calcular(2));

        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);
        productos.add(prod4);
        productos.add(prod5);

        for(int i = 0; i < productos.size(); i++){
            System.out.println("Precio total del " + productos.get(i).nombre + ": " + productos.get(i).calcular(5));
        }

    }
}
