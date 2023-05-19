import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Producto [] productos = {new Perecedero("Leche", 2000, 2), new Perecedero("Manzanas", 100, 3), new Perecedero("Carne", 500, 1), new Perecedero("Pan", 1000, 1), new Perecedero("Yogur", 500, 5), new NoPerecedero("Atún", 1000, "enlatado"), new NoPerecedero("Arroz", 2000, "empacado"), new NoPerecedero("Aceite", 1500, "botella"), new NoPerecedero("Sal", 500, "bolsa"), new NoPerecedero("Azúcar", 1000, "paquete")};
        double totalPerecedero = 0;
        double totalNoPerecedero = 0;
        for (Producto producto: productos){
            if (producto instanceof Perecedero) totalPerecedero += producto.calcular(1);
            else totalNoPerecedero+=producto.calcular(1);
        }
        System.out.println("El total de perecederos es: " + totalPerecedero);
        System.out.println("El total de no perecederos es: " + totalNoPerecedero);
    }
}