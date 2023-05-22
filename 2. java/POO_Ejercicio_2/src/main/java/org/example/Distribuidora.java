package org.example;

public class Distribuidora {

//    array de 15 productos
    private Producto[] productos = {
            new Producto("Leche", 50),
            new Producto("Arroz", 20),
            new Producto("Azucar", 10),
            new Producto("Yogurt", 20),
            new Producto("Frijol", 30),

            new Perecedero(1, "Leche", 50),
            new Perecedero(2, "Pan", 20),
            new Perecedero(3, "Jugo", 30),
            new Perecedero(3, "Agua", 43),
            new Perecedero(3, "Jugo", 30),

            new NoPerecedero("Limpieza", "Jabon", 40),
            new NoPerecedero("Limpieza", "Shampoo", 60),
            new NoPerecedero("Limpieza", "Cepillo", 60),
            new NoPerecedero("Limpieza", "Crema", 60),
            new NoPerecedero("Limpieza", "Shampoo", 60)
    };

    public Distribuidora() {
//        mostrarProductos();
    }

//    mostrar el precio tras vender los productos por categoria
    public void mostrarProductos(){
        double totalPerecederos = 0;
        double totalNoPerecederos = 0;
        double totalProductos = 0;

        for (Producto producto : productos) {
            if (producto instanceof Perecedero) {
                totalPerecederos += producto.calcular(1);
            } else if (producto instanceof NoPerecedero) {
                totalNoPerecederos += producto.calcular(1);
            }
            totalProductos += producto.calcular(1);
        }

        System.out.printf("Total de productos perecederos: %.2f\n", totalPerecederos);
        System.out.printf("Total de productos no perecederos: %.2f\n", totalNoPerecederos);
        System.out.printf("Total de productos: %.2f\n", totalProductos);

    }

}
