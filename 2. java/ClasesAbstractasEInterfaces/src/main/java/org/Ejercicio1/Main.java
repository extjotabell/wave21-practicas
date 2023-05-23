package org.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //lista de transacciones
        List<Transaccion> transacciones = new ArrayList<Transaccion>();
        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        RetiroEfectivo retiro = new RetiroEfectivo();
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        PagoServicios pagoServicios = new PagoServicios();

        //Creación de clientes
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        ejecutivo.deposito();
        ejecutivo.transferencia();
        basic.consultarSaldo();
        basic.pagarServicio();
        basic.retiroEfectivo();
        cobrador.retirarEfectivo();
        cobrador.consultarSaldo();
    }
}
