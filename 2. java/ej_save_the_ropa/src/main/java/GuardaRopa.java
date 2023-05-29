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
        this.guardaropas.put(contador,listaDePrendas);
        return this.contador++;
    }

    public void mostrarPrendas(){
        if (this.guardaropas.size() == 0){
            System.out.println("No hay prendas guardadas");
        }else{
            System.out.println("Las prendas guardadas actualmente son:");
            this.guardaropas.forEach((k,v) -> {
                System.out.print("Con número " + k + " se tienen las prendas: [ ");
                v.forEach(p -> System.out.print(p + " "));
                System.out.println("]");
            });
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.guardaropas.get(numero);
    }
}
