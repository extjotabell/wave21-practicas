import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> diccionario;

    private int identificador;

    public GuardaRopa() {
        diccionario = new HashMap<>();
        identificador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        diccionario.put(identificador,listaDePrendas);
        return identificador++;
    }


    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            int numero = entry.getKey();
            List<Prenda> prendas = entry.getValue();

            System.out.println("Número: " + numero);

            for (Prenda prenda : prendas) {
                System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }

            System.out.println();
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.get(numero);
    }

}
