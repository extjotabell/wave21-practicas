package org.example.ejercicio1;

import org.example.ejercicio1.clases.Basico;
import org.example.ejercicio1.clases.Cobrador;
import org.example.ejercicio1.clases.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        basico.realizarConsulta();
        cobrador.realizarRetiro();
        ejecutivo.realizarTransferencia();
    }
}