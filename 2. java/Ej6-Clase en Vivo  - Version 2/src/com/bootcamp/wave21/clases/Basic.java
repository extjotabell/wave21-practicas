package com.bootcamp.wave21.clases;

import com.bootcamp.wave21.interfaces.ConsultaDeSaldo;
import com.bootcamp.wave21.interfaces.PagoDeServicio;
import com.bootcamp.wave21.interfaces.RetiroDeEfectivo;

public class Basic extends TipoCliente implements ConsultaDeSaldo, PagoDeServicio, RetiroDeEfectivo {
    private double saldo = 100;

    public Basic(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Se esta realizando una consulta de salgo para el tipo de cliente " + getClass().getSimpleName());
        System.out.println("Su saldo es " + this.saldo);
    }

    @Override
    public void pagarServicio() {
        System.out.println("Se esta realizando un pago de servicio desde el tipo de cliente " + getClass().getSimpleName());

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
