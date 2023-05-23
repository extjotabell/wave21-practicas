package org.example.ejercicio1.clases;

import org.example.ejercicio1.interfaces.ConsultaSaldo;
import org.example.ejercicio1.interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void realizarConsulta() {
        if (true) {
            System.out.println("Consulta realizada por un cobrador");
            transaccionOk();
        } else transaccionNoOk();
    }

    @Override
    public void realizarRetiro() {
        if (true) {
            System.out.println("Retiro realizado por un cobrador");
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
