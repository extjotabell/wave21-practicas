import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Lacoste","Playera");
        Prenda prenda2 = new Prenda("Levi's","Pantalon");
        Prenda prenda3 = new Prenda("Nike","Playera");

        GuardaRopa guardaRopa = new GuardaRopa();

        Integer codigo = guardaRopa.guardarPrendas(Arrays.asList(prenda1,prenda2,prenda3));

        System.out.println("Se guardo la ropa con identificador: "+codigo);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendas = guardaRopa.devolverPrendas(codigo);
        for (Prenda prenda: prendas) {
            System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
        }

    }
}