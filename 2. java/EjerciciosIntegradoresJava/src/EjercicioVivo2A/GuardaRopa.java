package EjercicioVivo2A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> mapPrendas;
    Integer contador = 1;

    public GuardaRopa() {
        this.mapPrendas = new HashMap<>();
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int posicionPrenda = contador;
        mapPrendas.put(contador, listaDePrenda);
        contador++;
        return posicionPrenda;
    }

    public void mostrarPrendas(){
        for(Map.Entry<Integer, List<Prenda>> entry: mapPrendas.entrySet()){
            int clave = entry.getKey();
            List<Prenda> valoresPrendas = entry.getValue();
            System.out.println("Clave: " + clave);
            for (Prenda prenda: valoresPrendas) {
                System.out.println("Prenda marca: " + prenda.getMarca() + " , modelo: " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrenda(Integer numero){
        List<Prenda> lista = new ArrayList<>();
        for(Map.Entry<Integer, List<Prenda>> entry: mapPrendas.entrySet()){
            int clave = entry.getKey();
            if(clave == numero){
                List<Prenda> valoresPrenda = entry.getValue();
                for (Prenda prenda: valoresPrenda) {
                    lista.add(prenda);
                }
            }
        }
        return lista;
    }
}
