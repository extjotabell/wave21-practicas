package Clientes;

import Transacciones.ConsultaDeSaldo;
import Transacciones.PagoDeServicios;
import Transacciones.RetiroDeEfectivo;

public class Basic {

    public void consultarSaldo(){
        new ConsultaDeSaldo().consultarSaldo();
    }

    public void pagarServicios(){
        new PagoDeServicios().pagarServicios();
    }

    public void retirarEfectivo(){ new RetiroDeEfectivo().retirarDinero();}
}
