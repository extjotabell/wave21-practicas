package org.example.ejercicio1.clases;

import org.example.ejercicio1.interfaces.ConsultaSaldo;
import org.example.ejercicio1.interfaces.PagoServicios;
import org.example.ejercicio1.interfaces.RetiroEfectivo;

public class Basico implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void realizarConsulta() {
        if (true) {
            System.out.println("Consulta realizada por un basico");
            transaccionOk();
        } else transaccionNoOk();
    }

    @Override
    public void realizarPago() {
        if (true) {
            System.out.println("Pago realizado por un basico");
            transaccionOk();
        } else transaccionNoOk();

    }

    @Override
    public void realizarRetiro() {
        if (true) {
            System.out.println("Retiro realizado por un basico");
            transaccionOk();
        } else transaccionNoOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada correctamente");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion interrumpida debido a un fallo");
    }
}
