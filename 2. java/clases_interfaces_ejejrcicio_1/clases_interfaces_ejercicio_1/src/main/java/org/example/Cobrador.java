package org.example;

public class Cobrador implements RetiroDinero, ConsultaSaldo{
    @Override
    public void consultaSaldo() {
        System.out.println("Consultando Saldo....");

    }

    @Override
    public void retiroDinero() {
        System.out.println("Retira Dinero....");

    }

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion OK....");


    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion No OK....");


    }
}
