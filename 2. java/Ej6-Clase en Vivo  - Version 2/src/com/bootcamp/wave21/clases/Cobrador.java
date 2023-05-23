package com.bootcamp.wave21.clases;

import com.bootcamp.wave21.interfaces.ConsultaDeSaldo;
import com.bootcamp.wave21.interfaces.RetiroDeEfectivo;

public class Cobrador extends TipoCliente implements RetiroDeEfectivo, ConsultaDeSaldo {

    public Cobrador(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Se esta realizando una consulta de saldo desde el tipo de cliente " + getClass().getSimpleName());

    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Se esta retirando efectivo desde el tipo de cliente " + getClass().getSimpleName());

    }

    @Override
    public boolean transaccionOK() {
        return true;
    }

    @Override
    public boolean transaccionNoOK() {
        return false;
    }
}
