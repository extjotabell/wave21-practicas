package org.example.Transaccion;

public class RetiroDinero implements Transaccion{

    public double monto;

    public RetiroDinero(double monto) {
        this.monto = monto;
    }

    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void realizar() {
        System.out.println("Se retiraron $" + monto + " de la cuenta");
    }
}
