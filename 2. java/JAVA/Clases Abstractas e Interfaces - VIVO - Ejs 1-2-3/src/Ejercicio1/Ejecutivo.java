package Ejercicio1;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito(int monto) {
        /*
        if(condicion)
            transaccionOk();
        else
            transaccionNoOk();
         */
    }

    @Override
    public void realizarTransferencia(int monto) {
        /*
        if(condicion)
            transaccionOk();
        else
            transaccionNoOk();
         */
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transaccion se realizo con exito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transaccion no se pudo reallizar");

    }
}
