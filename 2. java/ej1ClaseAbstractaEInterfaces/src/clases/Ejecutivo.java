package clases;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void transaccionOk() {
        System.out.println("interfaces.Transaccion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("interfaces.Transaccion fallida");
    }

    @Override
    public void deposito() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void transferencia() {
        System.out.println("Realizando deposito");
    }
}
