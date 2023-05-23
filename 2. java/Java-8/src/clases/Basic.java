package clases;

import interfaces.Consulta;
import interfaces.Pago;
import interfaces.Retiro;

public class Basic implements Consulta, Pago, Retiro {
    @Override
    public void hacerConsulta() {
        System.out.println("Hacer consulta");
    }

    @Override
    public void hacerPago() {
        System.out.println("Hacer pago");
    }

    @Override
    public void hacerRetiro() {
        System.out.println("Hacer retiro");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }
}
