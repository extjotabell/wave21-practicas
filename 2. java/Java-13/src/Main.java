import clases.GuardaRopa;
import clases.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Nike", "Model1"));
        prendas.add(new Prenda("Adidas", "Model2"));

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer numero = guardaRopa.guardarPrendas(prendas);

        System.out.println(guardaRopa.devolverPrendas(numero));
        guardaRopa.mostrarPrendas();
    }
}