package org.Ejercicio1;

public class Cobrador {
    Transaccion transaccion;

    public Cobrador(){

    }

    public void retirarEfectivo(){
        this.transaccion= new RetiroEfectivo();
        this.transaccion.transaccionOk();
    }

    public void consultarSaldo(){
        this.transaccion = new ConsultaSaldo();
        this.transaccion.transaccionNoOk();
    }
}
