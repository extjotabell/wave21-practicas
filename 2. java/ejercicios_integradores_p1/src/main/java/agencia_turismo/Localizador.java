package agencia_turismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Localizador implements Identificable {
    private final Map<Class<? extends Reserva>, List<Reserva>> reservas;
    private int id;
    private int clienteId;
    private int reservasHechas;

    public Localizador(int idCliente) {
        this.clienteId = idCliente;
        this.reservas = new HashMap<>();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public Map<Class<? extends Reserva>, List<Reserva>> getReservas() {
        return reservas;
    }

    public int getCantidadReservasHechas() {
        return this.reservasHechas;
    }

    public void agregarReserva(Reserva reserva) {
        this.agregarAReserva(reserva);
    }

    private void agregarAReserva(Reserva reserva) {
        this.reservas.computeIfAbsent(reserva.getClass(), k -> new ArrayList<>()).add(reserva);
        this.reservasHechas++;
    }

    public void agregarMultiplesReservas(List<Reserva> reservas) {
        reservas.forEach(this::agregarAReserva);
    }

    public double getCostoTotal() {
        double[] subtotal = {0};
        aplicarDescuentoPorCadaDupla(this.reservas.get(ReservaVuelo.class), 5);
        aplicarDescuentoPorCadaDupla(this.reservas.get(ReservaHotel.class), 5);
        this.reservas.forEach((tr, lr) -> lr.forEach(r -> subtotal[0] += r.getCosto()));
        return subtotal[0];
    }

    private void aplicarDescuentoPorCadaDupla(List<Reserva> reservas, int porcentajeDescuento) {
        if (reservas == null) {
            return;
        }
        int reservaPrevia = -1;
        for (int i = 0; i < reservas.size(); i++) {
            if (reservaPrevia == -1) {
                reservaPrevia = i;
            } else {
                reservas.get(reservaPrevia).aplicarDescuento(porcentajeDescuento);
                reservas.get(i).aplicarDescuento(porcentajeDescuento);
                reservaPrevia = -1;
            }
        }
    }

    public boolean esPaqueteCompleto() {
        final boolean[] esCompleto = {true};
        this.reservas.forEach((r, lr) -> esCompleto[0] = esCompleto[0] && lr.size() > 0);
        return esCompleto[0];
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", reservas=" + reservas +
                ", costoTotal=" + this.getCostoTotal() +
                '}';
    }
}
