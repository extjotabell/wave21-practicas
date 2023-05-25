package agencia_turismo;

public class ReservaHotel extends Reserva {
    public ReservaHotel(double costo) {
        super(costo);
    }

    @Override
    public String toString() {
        return "Reserva de hotel con costo: " + super.toString();
    }
}
