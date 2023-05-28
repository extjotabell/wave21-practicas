package clases;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente datosCliente;
    private List<Reserva> reserva;
    private double montoTotal;

    public Localizador(Cliente cliente, List<Reserva> reserva, double montoTotal) {
        this.datosCliente = cliente;
        this.reserva = reserva;
        this.montoTotal = montoTotal;
    }

    public Cliente getCliente() {
        return datosCliente;
    }

    public void setCliente(Cliente cliente) {
        this.datosCliente = cliente;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
