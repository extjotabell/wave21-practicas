package clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> ropero = new HashMap<>();
    private Integer cont = Integer.valueOf(0);

    public Integer guardarPrendas(List<Prenda> prendas){
        this.cont++;
        this.ropero.put(this.cont, prendas);

        return this.cont;
    }

    public void mostrarPrendas(){
        System.out.println(ropero);
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return ropero.get(numero);
    }
}
