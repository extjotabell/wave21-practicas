package org.Ejercicio1;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retirando el efectivo, por favor espere...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el retiro");
    }
}
