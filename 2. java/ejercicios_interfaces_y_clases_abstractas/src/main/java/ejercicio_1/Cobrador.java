package ejercicio_1;

import ejercicio_1.transacciones.ConsultaSaldo;
import ejercicio_1.transacciones.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {

    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    @Override
    public void obtenerSaldo() {
        System.out.println("Su saldo es: 500");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
    }
}
