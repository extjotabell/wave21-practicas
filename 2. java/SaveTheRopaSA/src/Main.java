import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Nike", "Zapatillas Air Max 90"));
        prendas.add(new Prenda("Adidas", "Pantalon deportivo Essentials"));

        ArrayList<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(new Prenda("Levis", "Camiseta blanca de algodón"));
        prendas2.add(new Prenda("Gucci", "Cinturin de cuero negro"));

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigo = guardaRopa.guardarPredas(prendas);
        Integer codigo2 = guardaRopa.guardarPredas(prendas2);
        System.out.println("Codigo = " + codigo);

        guardaRopa.mostrarPrendas();

        System.out.println("Prendas id 1: ");
        guardaRopa.devolverPrendas(codigo).forEach(System.out::println);
    }
}