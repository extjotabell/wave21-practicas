package org.example.Transaccion;

public class Transferencia implements Transaccion {

    double montoATransferir;

    public Transferencia(double montoATransferir) {
        this.montoATransferir = montoATransferir;
    }

    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void realizar() {
        System.out.println("Se realizo una transferencia por $" + montoATransferir);
    }
}
