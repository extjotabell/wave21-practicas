package org.example;

public class Localizador {
    Cliente cliente;
    int total;
    PaqueteTuristico reserva;

    public Localizador(Cliente cliente, int total, PaqueteTuristico reserva) {
        this.cliente = cliente;
        this.total = total;
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public PaqueteTuristico getReserva() {
        return reserva;
    }

    public void setReserva(PaqueteTuristico reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reserva=" + reserva +
                '}';
    }
}
