package org.example;

public class Ejecutivo implements RealizarDeposito, Transferencia{
    @Override
    public void realiarDeposito() {
        System.out.println("Realiza Deposito....");


    }

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion OK....");


    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion No OK....");


    }

    @Override
    public void transaccion() {
        System.out.println("Transaccion....");



    }
}
