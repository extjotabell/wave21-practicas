import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    public Integer id;
    public Map<Integer, ArrayList<Prenda>> armario;

    public GuardaRopa() {
        this.armario = new HashMap<>();
        this.id = 1;
    }

    public Integer guardarPredas(ArrayList<Prenda> listaDePrendas){
        armario.put(id, listaDePrendas);
        Integer respuesta = id;
        id++;
        return respuesta;
    }

    public void mostrarPrendas() {
        armario.forEach((id, prendas) -> {
            System.out.println("Id:" + id);
            prendas.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer id){
        return armario.get(id);
    }


}
