package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda> > listaDePrendas;
    private  int contador;
    public GuardaRopa(Map<Integer, List<Prenda>> listaDePrendas) {
        this.listaDePrendas = listaDePrendas;
        contador = 1;
    }

    public GuardaRopa() {
        listaDePrendas = new HashMap<Integer, List<Prenda>>();
        contador = 1;
    }

    private int incrementarContador(){
        return  this.contador + 1;
    }

    public Integer guardarPrenda(List<Prenda> prendas){
        int numeroAsignado = incrementarContador();
        this.listaDePrendas.put(numeroAsignado,prendas);
        return numeroAsignado;
    }

    public void mostrarTodasLasPrendas(){
        for (Map.Entry<Integer, List<Prenda>> prendas : listaDePrendas.entrySet()) {
            System.out.println("El codigo" + prendas.getKey() + "tiene las siguientes prendas" );
            for(Prenda prenda: prendas.getValue()){
                System.out.println(prenda.toString());
            }
        }
    }

    public void mostrarPrendasPorNumero(int valor){

            List<Prenda> prendas = this.listaDePrendas.get(valor);
            if(prendas == null){
                System.out.println("No hay prendas en el guardaropa con ese identificador");
            }else{
                System.out.println("Marca\t\tModelo");
                for(Prenda prenda: prendas){
                    System.out.println(prenda.toString());
                }
            }


    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prendas = this.listaDePrendas.get(numero);
        this.listaDePrendas.remove(numero);
        return prendas;

    }


}
