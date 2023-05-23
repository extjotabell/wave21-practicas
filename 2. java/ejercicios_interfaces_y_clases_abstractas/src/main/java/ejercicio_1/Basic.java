package ejercicio_1;

import ejercicio_1.transacciones.ConsultaSaldo;
import ejercicio_1.transacciones.PagoServicios;
import ejercicio_1.transacciones.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
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
        System.out.println("Su saldo es: 1000");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Pagando servicio");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo");
    }
}
