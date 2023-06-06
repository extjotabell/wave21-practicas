package org.example;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroDinero{

    @Override
    public void consultaSaldo() {
        System.out.println("Consultando Saldo....");
    }

    @Override
    public void pagoServicio() {
        System.out.println("Paga Servicio....");

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
