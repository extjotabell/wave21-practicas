import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    private Map<Integer, List<Prenda>> guardaropas;

    public GuardaRopa(int contador){
        this.contador = contador;
        this.guardaropas = new HashMap<>();
    }

    public GuardaRopa(int contador, Map<Integer, List<Prenda>> guardaropas) {
        this.contador = contador;
        this.guardaropas = guardaropas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        this.guardaropas.put(contador++,listaDePrendas);
        return this.contador;
    }

    public void mostrarPrendas(){
        this.guardaropas.forEach((k,v) -> {
            System.out.print("Con número " + k + " se tienen las prendas: [ ");
            v.forEach(System.out::print);
            System.out.println("]");
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.guardaropas.get(numero);
    }
}
