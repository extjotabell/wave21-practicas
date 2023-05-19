public class Distribuidora {
    public static void main(String[] args) {
        Producto[] products = {
                new NoPerecedero("Agua Salus 1L", 60, "Agua"),
                new Perecedero("Leche 1L", 50, 3)
        };

        System.out.println("Precio total: " + (products[0].calculate(5) + products[1].calculate(5)));
    }
}