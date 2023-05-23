package main;
import java.util.ArrayList; // import the ArrayList


public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        Perecedero alimento1 = new Perecedero("Manzana", 2.5, 2);
        Perecedero alimento2 = new Perecedero("Lechuga", 1.8, 3);
        Perecedero alimento3 = new Perecedero("Banana", 0.9, 1);
        Perecedero alimento4 = new Perecedero("Cebolla", 2.5, 2);
        Perecedero alimento5 = new Perecedero("Tomate", 1.8, 3);

        NoPerecedero alimento6 = new NoPerecedero("Arroz", 3.5, "Granos");
        NoPerecedero alimento7 = new NoPerecedero("Aceite", 2.8, "Aceite");
        NoPerecedero alimento8 = new NoPerecedero("Azucar", 1.9, "Endulzantes");
        NoPerecedero alimento9 = new NoPerecedero("Sal", 4.5, "Condimentos");
        NoPerecedero alimento10 = new NoPerecedero("Cafe", 3.8, "Bebidas");

        productos.add(alimento1);
        productos.add(alimento2);
        productos.add(alimento3);
        productos.add(alimento4);
        productos.add(alimento5);
        productos.add(alimento6);
        productos.add(alimento7);
        productos.add(alimento8);
        productos.add(alimento9);
        productos.add(alimento10);

        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Precio Total de 5 unidades: " + producto.calcular(5));

            if (producto instanceof Perecedero) { //Instanciando Perecedero
                Perecedero perecedero = (Perecedero) producto; // Aplicando Casting polimorf
                System.out.println("Días por caducar: " + perecedero.getDiasPorCaducar());
            } else if (producto instanceof NoPerecedero) { //Instanciando NoPerecedero
                NoPerecedero noPerecedero = (NoPerecedero) producto; //Aplicando Casting polimorf
                System.out.println("Tipo: " + noPerecedero.getTipo());
            }
            System.out.println("----------------------");
        }
    }
}