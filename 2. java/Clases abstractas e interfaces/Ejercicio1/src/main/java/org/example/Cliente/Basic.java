package org.example.Cliente;

import org.example.Transaccion.ConsultaSaldo;
import org.example.Transaccion.PagoServicios;
import org.example.Transaccion.RetiroDinero;

public class Basic extends Cliente{

    public void realizarConsultaSaldo() {
        ConsultaSaldo consulta = new ConsultaSaldo();
        consulta.realizar();
    }

    public void realizarPagoServicio(String servicio, double monto) {
        PagoServicios pagoServicios = new PagoServicios(servicio, monto);
        pagoServicios.realizar();
    }

    public void realizarRetiro(double monto) {
        RetiroDinero retiro =  new RetiroDinero(monto);
        retiro.realizar();
    }
}

