package com.bootcamp.wave21;

public class PagoDeServicio implements Transaccion{
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
        return "Acabas de pagar el servicio solicitado";
    }
}
