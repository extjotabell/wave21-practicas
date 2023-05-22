package com.bootcamp.wave21;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Ejecutivo extends TipoDeCliente{
/*Realizan Depósitos y Transferencias*/

    private String nombre;
    private Map<String,Transaccion> misTransacciones;

    public Ejecutivo(String nombre){
        this.nombre = nombre;
        this.misTransacciones = generarTransacciones();
    }

    public Map<String,Transaccion> generarTransacciones(){
        Map<String,Transaccion> misTransacciones = new HashMap<String, Transaccion>();
        misTransacciones.put("Deposito",new Deposito());
        misTransacciones.put("Transferencia",new Transferencia());
        return misTransacciones;
    }



    public void transaccionesHabilitadas(){
        System.out.println("Las Transacciones habilitadas para un Ejecutivo son");
        for (Map.Entry<String, Transaccion> entry : misTransacciones.entrySet()) {
            System.out.println("Transaccion= " + entry.getKey());
        }

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, Transaccion> getMisTransacciones() {
        return misTransacciones;
    }

    public void setMisTransacciones(Map<String, Transaccion> misTransacciones) {
        this.misTransacciones = misTransacciones;
    }
}
