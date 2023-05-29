package clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
    }

    public GuardaRopa(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        int size=1;
        if(this.prendas!=null){
            size = this.prendas.keySet().size()+1;
        }else if(this.prendas==null){
            this.prendas=new HashMap<>();
        }
        this.prendas.put(size,listaDePrenda);
        return size;
    }

    public void mostrarPrendas(){
        this.prendas.forEach((k,v)->{
            System.out.println(v.toString()+"\n"+"En la key "+k);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.prendas.get(numero);
    }
}
