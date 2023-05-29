import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Adidas", "Canguro X");
        Prenda prenda2 = new Prenda("Nike", "Prenda Y");

        GuardaRopa guardaRopa = new GuardaRopa(1);

        guardaRopa.mostrarPrendas();

        int numeroDeGuardado = guardaRopa.guardarPrendas(List.of(prenda1,prenda2));

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasGuardadas = guardaRopa.devolverPrendas(numeroDeGuardado);
        System.out.println("Las prendas recuperadas son: ");
        prendasGuardadas.forEach(System.out::println);


    }
}
