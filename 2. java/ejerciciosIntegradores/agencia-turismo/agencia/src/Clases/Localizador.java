package Clases;

import java.util.List;

public class Localizador {
    private String id;
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;


    public String getId() {
        return id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public String toString() {
        return "Localizador{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }
}
