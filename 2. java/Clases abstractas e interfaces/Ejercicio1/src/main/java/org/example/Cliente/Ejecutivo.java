package org.example.Cliente;

import org.example.Transaccion.Deposito;
import org.example.Transaccion.Transaccion;
import org.example.Transaccion.Transferencia;

public class Ejecutivo extends Cliente {

    private void realizarTransferencia(double monto) {
        Transferencia transferencia = new Transferencia(monto);
        transferencia.realizar();
    }
    private void realizarDeposito(double monto){
        Deposito deposito = new Deposito(monto);
        deposito.realizar();

    }
}
