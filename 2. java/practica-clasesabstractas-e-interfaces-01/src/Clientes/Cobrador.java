package Clientes;

import Transacciones.ConsultaDeSaldo;
import Transacciones.RetiroDeEfectivo;

public class Cobrador {
    public void retirarEfectivo(){ new RetiroDeEfectivo().retirarDinero();}
    public void consultarSaldo(){
        new ConsultaDeSaldo().consultarSaldo();
    }
}
