
public class Main {
    public static void main(String[] args) {
        /*
        PracticaExcepciones prueba = new PracticaExcepciones();
        prueba.calcularCociente();
         */

        Producto productos[] = new Producto[5];
        productos[0] = new Perecedero("Leche",15.4, 4);
        productos[1] = new Perecedero("Tomate",7.4, 2);
        productos[2] = new NoPerecedero("Arroz",14.0);
        productos[3] = new NoPerecedero("Fideo",10.0);
        productos[4] = new NoPerecedero("Yerba",6.0);

        Double total = 0.0;

        for (int i = 0; i < productos.length; i++){
            total += productos[i].calcular(5);
        }

        System.out.println("El total es " + Math.round(total));
    }
}