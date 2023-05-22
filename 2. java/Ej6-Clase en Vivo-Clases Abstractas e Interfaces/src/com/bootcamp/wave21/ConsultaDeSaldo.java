package com.bootcamp.wave21;

public class ConsultaDeSaldo implements Transaccion{

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
        return "Tu saldo es $0";
    }
}
