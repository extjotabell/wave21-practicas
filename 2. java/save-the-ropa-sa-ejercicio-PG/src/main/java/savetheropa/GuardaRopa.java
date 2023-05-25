package savetheropa;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaropa;
    private Integer identificador;

    public GuardaRopa() {
    }

    public Map<Integer, List<Prenda>> getGuardaropa() {
        return guardaropa;
    }

    public void setGuardaropa(Map<Integer, List<Prenda>> guardaropa) {
        this.guardaropa = guardaropa;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        Random random = new Random(4);
        this.identificador = random.nextInt();
        this.guardaropa = new HashMap<>();
        this.guardaropa.put(this.identificador,prendas);
        return this.identificador;
    }

    public void mostrarPrendas(){
        System.out.println("---------------------------------------------\n" +
                "PRENDAS:\n" +
                "---------------------------------------------");
        guardaropa.forEach((idem,prendaList) ->{
            prendaList.forEach(prenda -> {
                System.out.println("Modelo: " + prenda.getModelo() + "\n" +
                        "Marca: " + prenda.getMarca() + "\n" +
                        "Identificador: " + idem + "\n" +
                        "--------------------------");
            });
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        AtomicReference<List<Prenda>> result = new AtomicReference<>(new ArrayList<>());
        guardaropa.forEach((idem,prendaList) ->{
            if (Objects.equals(idem, numero)){
                result.set(prendaList);
            }
        });
        return result.get();
    }
}
