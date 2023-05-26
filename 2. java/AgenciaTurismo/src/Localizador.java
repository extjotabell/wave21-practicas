import java.util.ArrayList;

public class Localizador {
    private Cliente cliente;
    private ArrayList<Reserva> reservas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public void nuevaReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public double obtenerTotal() {
        return reservas.stream().mapToDouble(reserva -> reserva.precio).sum();
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void imprimir() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Reservas: ");
        reservas.forEach(System.out::println);
        System.out.println("Total: " + obtenerTotal());
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                '}';
    }
}
