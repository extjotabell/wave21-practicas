package clases;

import interfaces.Consulta;
import interfaces.Retiro;

public class Cobradores implements Retiro, Consulta {
    @Override
    public void hacerConsulta() {
        System.out.println("Hacer consulta");
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
