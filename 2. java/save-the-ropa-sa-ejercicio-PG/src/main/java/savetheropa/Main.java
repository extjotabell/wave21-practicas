package savetheropa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>(Arrays.asList(
                new Prenda("Adidas","Sombrero AXZ07"),
                new Prenda("Levis","Pantalon XLO98")));

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer identifier = guardaRopa.guardarPrendas(prendas);
        System.out.println("Se ha guardado. El número de identificador es: " + identifier);

        //Imprime todas las prendas
        guardaRopa.mostrarPrendas();

        //Imprime las prendas de un indentificador determinado
        imprimir(guardaRopa.devolverPrendas(identifier), identifier);
    }

    private static void imprimir(List<Prenda> prendas, Integer identificador){
        System.out.println("\n\n--------------------------------------\n" +
                "Identificador: " + identificador + "\n" +
                "--------------------------------------");
        prendas.forEach(prenda -> {
            System.out.println("Modelo: " + prenda.getModelo() + "\n" +
                    "Marca: " + prenda.getMarca() + "\n" +
                    "----------------");
        });
    }


}
