package org.example.Transaccion;

public class PagoServicios implements Transaccion{

    public String servicio;
    public double monto;

    public PagoServicios(String servicio, double monto) {
        this.servicio = servicio;
        this.monto = monto;
    }

    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOk() {

    }

    @Override
    public void realizar() {
        System.out.println("Se pagó el servicio " + servicio + "por un costo de $" + monto);
    }
}
