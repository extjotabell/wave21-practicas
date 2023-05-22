package com.bootcamp.wave21;

public class Transferencia implements Transaccion{
    @Override
    public boolean transaccionOK() {
        return true;
    }

    @Override
    public boolean transaccionNoOK() {
        return false;
    }

    @Override
    public String mostrarTransaccion() {
        return "Acabas de realizar una transferencia";
    }
}
