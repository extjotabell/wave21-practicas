import java.util.List;

class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, double total, List<Reserva> reservas) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public boolean esPaqueteCompleto() {
        // Verificar si el localizador contiene las reservas necesarias para un paquete completo
        boolean tieneReservaHotel = false;
        boolean tieneReservaComida = false;
        boolean tieneBoletoViaje = false;
        boolean tieneTransporte = false;

        for (Reserva reserva : reservas) {
            if (reserva instanceof ReservaHotel) {
                tieneReservaHotel = true;
            } else if (reserva instanceof ReservaComida) {
                tieneReservaComida = true;
            } else if (reserva instanceof BoletoViaje) {
                tieneBoletoViaje = true;
            } else if (reserva instanceof Transporte) {
                tieneTransporte = true;
            }
        }

        return tieneReservaHotel && tieneReservaComida && tieneBoletoViaje && tieneTransporte;
    }

    public boolean esReservaHotel() {
        // Verificar si el localizador contiene al menos 2 reservas de hotel
        int contadorReservasHotel = 0;

        for (Reserva reserva : reservas) {
            if (reserva instanceof ReservaHotel) {
                contadorReservasHotel++;
            }
        }

        return contadorReservasHotel >= 2;
    }

    public boolean esBoletoViaje() {
        // Verificar si el localizador contiene al menos 2 boletos de viaje
        int contadorBoletosViaje = 0;

        for (Reserva reserva : reservas) {
            if (reserva instanceof BoletoViaje) {
                contadorBoletosViaje++;
            }
        }

        return contadorBoletosViaje >= 2;
    }

    public String toString() {
        return "Localizador\nCliente: " + cliente.getNombre() + "\nTotal: $" + total + "\nReservas: " + reservas.size();
    }
}
