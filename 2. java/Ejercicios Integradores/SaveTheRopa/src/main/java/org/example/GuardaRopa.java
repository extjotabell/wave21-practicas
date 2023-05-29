package org.example;

import org.example.Prenda.Prenda;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> indicePrendas = new HashMap<>();
    private Integer contador = 0;


    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        indicePrendas.put(contador, listaDePrenda);
        contador++;
        return contador;
    }

    public void mostrarPrendas() {
        indicePrendas.forEach((ind, prendas) -> {
            // Realiza alguna operación con cada elemento del mapa
            System.out.println("-----------");
            System.out.println("Para la clave " + ind );
            prendas.forEach(p->p.imprimirInformacion());
            System.out.println("-----------");

            // Puedes realizar más operaciones aquí si es necesario
        });

    }

    public List<Prenda> devolverPrendas(Integer clave) {
     return indicePrendas.get(clave);
    }

}
