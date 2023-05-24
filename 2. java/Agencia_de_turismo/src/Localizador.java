import java.util.List;
import java.util.stream.Collectors;

public class Localizador {

    private Cliente cliente;

    private Double total;

    private List<Reserva> reservas;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total=0d;
        this.calcularTotal(reservas);
    }

    public void calcularTotal(List<Reserva> reservas){
        for (Reserva reserva:reservas
             ) {
            this.total += reserva.getCosto();
        }
    }

    public void imprimirLocalizador() {
        System.out.print("Localizador{" +
                "cliente="+cliente.toString());
        System.out.print(
                ", total=" + total +
                ", reservas= ");
        String reservasString = reservas.stream().map(n->n.getNombre()).collect(Collectors.joining(", "));
        System.out.print(reservasString);
        System.out.print("}\n");
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
