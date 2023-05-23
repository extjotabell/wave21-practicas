package com.bootcamp.wave21.clases;

import com.bootcamp.wave21.interfaces.Deposito;
import com.bootcamp.wave21.interfaces.Transferencia;

public class Ejecutivo extends TipoCliente implements Deposito, Transferencia {


    public Ejecutivo(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Se esta realizando el deposito desde el tipo de cliente " + getClass().getSimpleName());
    }

    @Override
    public boolean transaccionOK() {

        return true;
    }

    @Override
    public boolean transaccionNoOK() {
        return false;
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Se esta realizando una transferencia desde el tipo de cliente " + getClass().getSimpleName());

    }
}
