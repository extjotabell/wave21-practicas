package Main;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private Integer contador;

    public GuardaRopa() {
        prendas = new HashMap<>();
        contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
            prendas.put(contador, listaDePrenda);
            int identificador = contador;
            contador++;
            return identificador;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            Integer identificador = entry.getKey();
            List<Prenda> prendas = entry.getValue();
            System.out.println("Identificador: " + identificador);
            System.out.println("Prendas: " + prendas);
        }
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }
}
