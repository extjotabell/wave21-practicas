import java.util.ArrayList;
import java.util.List;

public class Localizador {
    Cliente cliente;
    Double total;
    List<Reservable> reservas = new ArrayList();

    public Localizador(Cliente cliente, List<Reservable> reservas) {
        this.cliente = cliente;
        this.total = calcularTotal(cliente,reservas);
        this.reservas = reservas;
    }

    private Double calcularTotal(Cliente cliente, List<Reservable> reservas) {
        return 0.0;
    }

    public void agregarReserva(Reservable reserva){
        this.reservas.add(reserva);
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reservable> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservable> reservas) {
        this.reservas = reservas;
    }
}
