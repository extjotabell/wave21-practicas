package Main;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creo el guarda ropas
        GuardaRopa guardaRopa = new GuardaRopa();

        // Creando listas
        List<Prenda> listaPrendas1 = new ArrayList<>();
        List<Prenda> listaPrendas2 = new ArrayList<>();

        // Creando objetos
        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");
        Prenda prenda3 = new Prenda("Gucci", "Vestido");
        Prenda prenda4 = new Prenda("Zara", "Zapatos");

        //Agregando objetos a listas
        listaPrendas1.add(prenda1);
        listaPrendas1.add(prenda2);
        listaPrendas2.add(prenda3);
        listaPrendas2.add(prenda4);

        //llamando a guardaRopa y visualizando por consola el dientificador
        int identificador = guardaRopa.guardarPrendas(listaPrendas1);
        System.out.println("Identificador de la prenda guardada: " + identificador);
        int identificador2 = guardaRopa.guardarPrendas(listaPrendas2);
        System.out.println("Identificador de la prenda guardada: " +identificador2);
        // Llamando a mostrarPrendas() para ver todas las prendas y su identificador
        guardaRopa.mostrarPrendas();
        // Llamando a devolverPrendas para ver si funciona y devuelve dicha prenda
        System.out.println(guardaRopa.devolverPrendas(1));

    }
}
