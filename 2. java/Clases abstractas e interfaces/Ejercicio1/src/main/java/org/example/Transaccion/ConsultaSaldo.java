package org.example.Transaccion;

import org.example.Transaccion.Transaccion;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void realizar() {
        System.out.println("Se realizo una connsulta al saldo de la cuenta");
    }
}
