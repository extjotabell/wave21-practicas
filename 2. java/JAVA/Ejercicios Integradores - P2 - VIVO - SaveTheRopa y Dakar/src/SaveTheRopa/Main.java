package SaveTheRopa;

import java.security.Guard;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Se instancian diferentes Prendas
        Prenda p1 = new Prenda("Mistral","Grey Shirt");
        Prenda p2 = new Prenda("Nike","Running Shoes");
        Prenda p3 = new Prenda("Tommy Hilfiger","Polo Blue");
        Prenda p4 = new Prenda("GAP","Grey Hoodie");
        Prenda p5 = new Prenda("H&M","Beige Cargo Pants");

        //Se colocan en listas de Prendas
        List<Prenda> prendas1 = new ArrayList<Prenda>();
        List<Prenda> prendas2 = new ArrayList<Prenda>();
        prendas1.add(p1);
        prendas1.add(p2);
        prendas2.add(p3);
        prendas2.add(p4);
        prendas2.add(p5);

        //Se instancia un ropero
        GuardaRopa ropero = new GuardaRopa();

        //Se llama al metodo para guardar Prendas en el ropero
        ropero.guardarPrendas(prendas1);
        ropero.guardarPrendas(prendas2);

        //Se llama al metodo para mostrar el ropero y sus prendas.
        ropero.mostrarPrendas();

        //Se imprime la lista de Prendas del mapaRopa de id = 0 que nos devuelve el metodo devolverPrendas
        for(Prenda prenda : ropero.devolverPrendas(0)){
            System.out.println(prenda);
        }

    }
}