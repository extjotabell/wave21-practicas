package com.bootcamp.wave21;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo("Juan Roman");
        Cobrador cobrador = new Cobrador("Elsa Lamandra");
        Basic basico = new Basic("ELton Mate");

        ejecutivo.transaccionesHabilitadas();
        cobrador.transaccionesHabilitadas();
        basico.transaccionesHabilitadas();
        System.out.println("EJECUCION DE TRANSACCIONES");
        /** EJECUTO TRANSACCIONES DE EJECUTIVO**/
        for (Map.Entry<String, Transaccion> entry : ejecutivo.getMisTransacciones().entrySet()) {
            System.out.println("Se lleva a cabo la siguiente transaccion = " + entry.getKey());
            System.out.println(entry.getValue().mostrarTransaccion());
        }

        /** EJECUTO TRANSACCIONES DE BASIC**/
        for (Map.Entry<String, Transaccion> entry : basico.getMisTransacciones().entrySet()) {
            System.out.println("Se lleva a cabo la siguiente transaccion = " + entry.getKey());
            System.out.println(entry.getValue().mostrarTransaccion());
        }

        /** EJECUTO TRANSACCIONES DE COBRADOR**/
        for (Map.Entry<String, Transaccion> entry : cobrador.getMisTransacciones().entrySet()) {
            System.out.println("Se lleva a cabo la siguiente transaccion = " + entry.getKey());
            System.out.println(entry.getValue().mostrarTransaccion());

        }
    }
}
