package com.bootcamp.wave21;

import java.util.HashMap;
import java.util.Map;

public class Basic extends TipoDeCliente {
    /*Realizan consultas de saldo, pagos de servicios y retiro de efectivo.*/
    private String nombre;
    private Map<String, Transaccion> misTransacciones;

    public Basic(String nombre) {
        this.nombre = nombre;
        this.misTransacciones = generarTransacciones();
    }

    public Map<String, Transaccion> generarTransacciones() {
        Map<String, Transaccion> misTransacciones = new HashMap<String, Transaccion>();
        misTransacciones.put("Consulta de Saldo", new ConsultaDeSaldo());
        misTransacciones.put("Pago de Servicio", new PagoDeServicio());
        misTransacciones.put("Retiro de Efectivo", new RetiroDeEfectivo());
        return misTransacciones;
    }

    public void transaccionesHabilitadas() {
        System.out.println("Las transacciones habilitadas para un Basic son");
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
