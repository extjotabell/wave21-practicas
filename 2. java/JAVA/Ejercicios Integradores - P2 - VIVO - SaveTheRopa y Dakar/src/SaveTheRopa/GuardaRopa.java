package SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GuardaRopa {
    Map<Integer, List<Prenda> > mapaRopa;
    Integer id;

    public Integer guardarPrendas (List<Prenda> listaDePrenda){
        mapaRopa.put(id, listaDePrenda);
        int savedId = id;   //Guardamos el id que queremos devolver
        id++;               //Incrementamos el id para el siguiente guardaRopas
        return savedId;
    }

    public void mostrarPrendas(){
        mapaRopa.entrySet().stream()
                .forEach(x -> {
                    System.out.println("Id: " + x.getKey());
                    System.out.println("Prendas: " + x.getValue() + "\n");
                });
    }

    public List<Prenda> devolverPrendas (Integer id){
        return mapaRopa.get(id);        //get() nos devuelve el value del item con el key especificado.
    }

    public GuardaRopa() {
        this.mapaRopa = new HashMap<Integer, List<Prenda> >();;
        this.id = 0;
    }

    public Map<Integer, List<Prenda>> getMapaRopa() {
        return mapaRopa;
    }

    public void setMapaRopa(Map<Integer, List<Prenda>> mapaRopa) {
        this.mapaRopa = mapaRopa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
