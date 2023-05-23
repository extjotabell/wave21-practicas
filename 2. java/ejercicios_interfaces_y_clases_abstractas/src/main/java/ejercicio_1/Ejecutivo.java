package ejercicio_1;

import ejercicio_1.transacciones.Deposito;
import ejercicio_1.transacciones.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Realizando un deposito");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando una transferencia");
    }
}
