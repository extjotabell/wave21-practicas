package Clientes;

import Transacciones.Deposito;
import Transacciones.Transferencia;

public class Ejecutivo {
    public void realizarTransferencia(){ new Transferencia().transferir();}
    public void realizarDeposito(){ new Deposito().depositar();}
}
