package clases;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void hacerDeposito() {
        System.out.println("Hacer deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Hacer transferencia");
    }
}
