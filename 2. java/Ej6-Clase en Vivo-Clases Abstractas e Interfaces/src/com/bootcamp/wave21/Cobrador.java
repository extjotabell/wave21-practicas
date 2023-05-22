package com.bootcamp.wave21;

import java.util.HashMap;
import java.util.Map;

public class Cobrador extends TipoDeCliente {
    /*Realizan retiro de efectivo y consulta de saldos.*/

    private String nombre;
    private Map<String, Transaccion> misTransacciones;

    public Cobrador(String nombre) {
        this.nombre = nombre;
        this.misTransacciones = generarTransacciones();
    }

    public Map<String, Transaccion> generarTransacciones() {
        Map<String, Transaccion> misTransacciones = new HashMap<String, Transaccion>();
        misTransacciones.put("Retiro de Efectivo", new RetiroDeEfectivo());
        misTransacciones.put("Consulta de Saldo", new ConsultaDeSaldo());
        return misTransacciones;
    }

    public void transaccionesHabilitadas() {
        System.out.println("Las transacciones habilitadas para un Cobrador son");
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
