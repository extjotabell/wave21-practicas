import clases.GuardaRopa;
import clases.Prenda;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1= new Prenda("Nike","No se");
        Prenda prenda2= new Prenda("Adnice", "Tampoco");

        GuardaRopa guardaRopa= new GuardaRopa();
        System.out.println(guardaRopa.guardarPrendas(Arrays.asList(prenda1,prenda2)));
        System.out.println(guardaRopa.devolverPrendas(1));
    }
}