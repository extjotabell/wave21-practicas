package saveTheRopa;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda p1 = new Prenda("Marca1", "Modelo 1");
        Prenda p2 = new Prenda("Marca2", "Modelo 2");
        List<Prenda> prendasAGuardar = Arrays.asList(p1,p2);

        Integer prendasGuardadas = guardaRopa.guardarPrendas(prendasAGuardar);
        System.out.println("El identificador asignado para sus prendas es: " + prendasGuardadas);

        guardaRopa.mostrarPrendas();
    }
}