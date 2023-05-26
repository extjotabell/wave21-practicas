package agencia_turismo;

import java.util.*;
import java.util.stream.DoubleStream;

public class Localizador implements Identificable {
    private final Map<Class<? extends Reserva>, List<Reserva>> reservas;
    private final Map<Class<? extends Reserva>, Double> subTotalesPorTipoDeReserva;
    private int id;
    private Cliente cliente;
    private boolean correspondeDescuentoPorComprasReiteradas;
    private int reservasHechas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new HashMap<>();
        this.subTotalesPorTipoDeReserva = new HashMap<>();
        this.correspondeDescuentoPorComprasReiteradas = cliente.getLocalizadores().size() >= 2;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Map<Class<? extends Reserva>, List<Reserva>> getReservas() {
        return Collections.unmodifiableMap(reservas);
    }

    public int getCantidadReservasHechas() {
        return this.reservasHechas;
    }

    public void agregarReserva(Reserva reserva) {
        this.agregarAReserva(reserva);
    }

    private void agregarAReserva(Reserva reservaNueva) {
        this.reservas.computeIfAbsent(reservaNueva.getClass(), k -> new ArrayList<>()).add(reservaNueva);
        List<Reserva> reservasDeUnTipo = this.reservas.get(reservaNueva.getClass());
        if (correspondeDescuentoPorDupla(reservaNueva) && reservasDeUnTipo.size() > 0 && reservasDeUnTipo.size() % 2 == 0) {
            Reserva reservaPrevia = reservasDeUnTipo.get(reservasDeUnTipo.size() - 1);
            double sumaCostos = reservaNueva.getCosto() + reservaPrevia.getCosto();
            this.subTotalesPorTipoDeReserva.computeIfPresent(reservaNueva.getClass(), (k, v) -> v - reservaPrevia.getCosto() + (0.95 * sumaCostos));
        } else {
            this.subTotalesPorTipoDeReserva.compute(reservaNueva.getClass(), (k, v) -> (v == null) ? reservaNueva.getCosto() : v + reservaNueva.getCosto());
        }
        this.reservasHechas++;
    }

    private boolean correspondeDescuentoPorDupla(Reserva reserva) {
        return reserva instanceof ReservaVuelo || reserva instanceof ReservaHotel;
    }

    public void agregarMultiplesReservas(List<Reserva> reservas) {
        reservas.forEach(this::agregarAReserva);
    }

    public double getCostoConDescuentosAplicados() {
        double costoTotal = this.subTotalesPorTipoDeReserva.values().stream().flatMapToDouble(DoubleStream::of).sum();
        if (esPaqueteCompleto()) {
            costoTotal *= 0.9;
        }
        if (this.correspondeDescuentoPorComprasReiteradas) {
            costoTotal *= 0.9;
        }
        return costoTotal;
    }

    private boolean esPaqueteCompleto() {
        int catidadDeTiposDeReservas = 4;
        return this.reservas.size() == catidadDeTiposDeReservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", reservas=" + reservas +
                ", costoTotal=" + this.getCostoConDescuentosAplicados() +
                '}';
    }
}
