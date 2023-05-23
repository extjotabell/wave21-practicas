package org.Ejercicio1;

public class Transferencia implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Se realizo la transferencia con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se puedo realizar la transferencia");
    }
}
