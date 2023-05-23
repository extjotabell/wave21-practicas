package Transacciones;

import Transacciones.Transaccion;

public class Transferencia implements Transaccion {
    public void transferir(){
        System.out.println("Realizando transferencia");
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
