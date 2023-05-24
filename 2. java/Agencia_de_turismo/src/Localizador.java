import java.util.List;

public class Localizador {

    private Cliente cliente;

    private Double total;

    private List<Reserva> reservas;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.calcularTotal();
    }

    public void calcularTotal(){
        for (Reserva reserva:reservas
             ) {
            this.total += reserva.getCosto();
        }
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

    public List<Reserva> getReserva() {
        return reservas;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reservas = reserva;
    }
}
