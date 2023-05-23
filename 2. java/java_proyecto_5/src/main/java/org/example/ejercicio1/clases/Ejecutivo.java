package org.example.ejercicio1.clases;

import org.example.ejercicio1.interfaces.Deposito;
import org.example.ejercicio1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito() {
        if (true) {
            System.out.println("Se realizo un deposito de un ejecutivo");
            transaccionOk();
        } else transaccionNoOk();

    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada correctamente");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion interrumpida debido a un fallo");
    }

    @Override
    public void realizarTransferencia() {
        if (true) {
            System.out.println("Se realizo una transferencia de un ejecutivo");
            transaccionOk();
        } else transaccionNoOk();
    }
}
