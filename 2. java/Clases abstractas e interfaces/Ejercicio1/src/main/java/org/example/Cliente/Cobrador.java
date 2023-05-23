package org.example.Cliente;

import org.example.Transaccion.ConsultaSaldo;
import org.example.Transaccion.RetiroDinero;

public class Cobrador extends Cliente {

    public void realizarConsultaSaldo() {
        ConsultaSaldo consulta = new ConsultaSaldo();
        consulta.realizar();
    }

    public void realizarRetiro(double monto) {
        RetiroDinero retiro =  new RetiroDinero(monto);
        retiro.realizar();
    }
}
