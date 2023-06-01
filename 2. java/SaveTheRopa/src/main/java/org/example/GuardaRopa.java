package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    //recibe una lista de prendas y devuelve el número identificador en donde quedaron asignadas las prendas,

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(contador+1,listaDePrenda);
        contador++;
        return contador;
    };

    //imprime por pantalla todas las prendas que quedan en el
    // guardarropas junto con el número que les corresponde.

    public void mostrarPrendas(){
            /*for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
                System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
            }*/

        for (Integer key: diccionario.keySet()){
            List<Prenda> listaDePrendas = diccionario.get(key);
            System.out.println(listaDePrendas);
        }
    }

    //devuelve la lista de prendas que están guardadas bajo ese número.

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendasEncontrada = diccionario.remove(numero);

        /*List<Prenda> prendasEncontrada = new ArrayList<>();
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            if(entry.getKey() == numero){
                prendasEncontrada = entry.getValue();
            }
        }*/
        return prendasEncontrada;
    }

}


