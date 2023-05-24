import Reservas.Reserva;

import java.util.List;

public class Localizador {
    private List<Reserva> reservaList;
    private Cliente cliente;
    private double total;

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Localizador(List<Reserva> reservaList, Cliente cliente, double total) {
        this.reservaList = reservaList;
        this.cliente = cliente;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservaList=" + reservaList +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}
