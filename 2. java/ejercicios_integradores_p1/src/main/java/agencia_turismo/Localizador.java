package agencia_turismo;

import java.util.ArrayList;
import java.util.List;

public class Localizador  implements  Identificable {
    public Localizador(int idCliente) {
        this.clienteId = idCliente;
        this.reservas = new ArrayList<Reserva>();
    }

    public int getClienteId() {
        return clienteId;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int clienteId;
    private List<Reserva> reservas;
    private double costoTotal;
}
