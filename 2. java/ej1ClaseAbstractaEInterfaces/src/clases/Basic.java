package clases;

import interfaces.ConsultaSaldo;
import interfaces.PagoServicios;
import interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {

    @Override
    public void transaccionOk() {
        System.out.println("interfaces.Transaccion exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("interfaces.Transaccion fallida");
    }

    @Override
    public void consulta() {
        System.out.println("Su saldo es de: $"+Math.random());
    }

    @Override
    public void pago() {
        System.out.println("Realizando pago");
    }

    @Override
    public void retiro() {
        System.out.println("Retirando dinero");
    }
}
