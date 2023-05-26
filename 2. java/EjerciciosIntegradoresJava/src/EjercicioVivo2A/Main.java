package EjercicioVivo2A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Adidas", "Run21");
        Prenda prenda2 = new Prenda("Nike", "Agility23");
        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);
        System.out.println("Lista de prendas guardada en la posicion: " + guardaRopa.guardarPrendas(listaPrendas));
        System.out.println("-------------------");

        System.out.println("Todas las prendas guardadas: ");
        guardaRopa.mostrarPrendas();
        System.out.println("-------------------");

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un numero de prenda para buscar");
        Integer numero = sc.nextInt();
        buscarPrenda(guardaRopa.devolverPrenda(numero));
    }
    public static void buscarPrenda(List<Prenda> lista){
        System.out.println("Prendas encontradas con ese identificador:");
        for (Prenda prenda: lista){
            System.out.println("Prenda marca: " + prenda.getMarca() + ", modelo: " + prenda.getModelo());
        }
    }
}
