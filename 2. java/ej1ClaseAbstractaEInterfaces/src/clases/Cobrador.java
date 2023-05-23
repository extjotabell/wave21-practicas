package clases;

import interfaces.ConsultaSaldo;
import interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {

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
    public void retiro() {
        System.out.println("Retirando dinero");
    }
}
