package org.example.Transaccion;



public class Deposito implements Transaccion {

    double montoADepositar;

    public Deposito(double montoADepositar) {
        this.montoADepositar = montoADepositar;
    }

    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void realizar() {
        System.out.println("Se realizo un deposito por $" + montoADepositar);
    }
}
