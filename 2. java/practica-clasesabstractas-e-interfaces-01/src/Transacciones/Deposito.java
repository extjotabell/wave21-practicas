package Transacciones;

import Transacciones.Transaccion;

public class Deposito implements Transaccion {
    public void depositar(){
        System.out.println("Realizando deposito");
        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }
}
